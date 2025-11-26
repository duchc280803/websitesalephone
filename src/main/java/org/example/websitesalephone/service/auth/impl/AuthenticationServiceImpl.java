package org.example.websitesalephone.service.auth.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.websitesalephone.auth.JwtService;
import org.example.websitesalephone.auth.UserDetail;
import org.example.websitesalephone.dto.auth.AuthTokenResponse;
import org.example.websitesalephone.dto.auth.AuthUserDto;
import org.example.websitesalephone.dto.auth.ResetPasswordRequest;
import org.example.websitesalephone.dto.auth.ResetPasswordTokenDto;
import org.example.websitesalephone.entity.ExpiredToken;
import org.example.websitesalephone.entity.PasswordResetToken;
import org.example.websitesalephone.entity.User;
import org.example.websitesalephone.enums.RsTokenStatus;
import org.example.websitesalephone.repository.PasswordResetTokenRepository;
import org.example.websitesalephone.repository.TokenExpiredRepository;
import org.example.websitesalephone.repository.UserRepository;
import org.example.websitesalephone.service.auth.AuthenticationService;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.utils.Constants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;

@Service
@Log4j2
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final TokenExpiredRepository tokenExpiredRepository;

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public CommonResponse authenticate(AuthUserDto request) throws Exception {
        List<User> users = userRepository.findByUsername(request.getLoginId());
        if (users.isEmpty()) {
           return CommonResponse.
                   builder()
                   .code(CommonResponse.CODE_NOT_FOUND)
                   .build();
        }

        User activeUser = users.stream().filter(u -> !u.isDeleted()).findFirst().get();

        String rawPassword = request.getPasswordLogin().get();
        String encodedPassword = users.getFirst().getPasswordHash();

        if (!BCrypt.checkpw(rawPassword, encodedPassword)) {
            if (users.isEmpty()) {
                return CommonResponse.
                        builder()
                        .code(CommonResponse.CODE_PASSWORD)
                        .build();
            }
        }

        try {
            this.authenticationManager.authenticate(request.toAuthenticationToken());
        } catch (BadCredentialsException e) {
            // increase fail login count
            userRepository.save(activeUser);
            if (users.isEmpty()) {
                return CommonResponse.
                        builder()
                        .code(CommonResponse.CODE_PASSWORD)
                        .build();
            }
        }

        userRepository.save(activeUser);
        String token = jwtService.generateToken(UserDetail.fromEntity(activeUser));
        return CommonResponse.builder()
                .data(new AuthTokenResponse(token))
                .build();
    }

    @Override
    public CommonResponse setTokenExpired(String token) {
        ExpiredToken entity = new ExpiredToken();
        entity.setAccessToken(token);
        tokenExpiredRepository.save(entity);
        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .build();
    }

    @Override
    public CommonResponse forgotPassword(String email, String tabletOrPc) throws Exception {
        List<User> users = userRepository.findByEmail(email);
        if (users.isEmpty()) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("User email not found")
                    .build();
        }
        String userId = users.getFirst().getId();
        PasswordResetToken token = new PasswordResetToken();
        PasswordResetToken currentToken = passwordResetTokenRepository.findByUserId(userId).orElse(null);
        if (currentToken != null) {
            token = currentToken;
            token.setToken(RandomStringUtils.randomNumeric(6).toLowerCase(Locale.ROOT));
            token.setExpireTime(OffsetDateTime.now().plusHours(Constants.PASSWORD_RESET_MAIL_EXPIRED));
        } else {
            token.setToken(RandomStringUtils.randomNumeric(6).toLowerCase(Locale.ROOT));
            token.setExpireTime(OffsetDateTime.now().plusHours(Constants.PASSWORD_RESET_MAIL_EXPIRED));
            token.setUserId(userId);
        }

        token.setStatus(RsTokenStatus.WAITING);
        this.passwordResetTokenRepository.save(token);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(true)
                .build();
    }

    @Override
    public CommonResponse resetPassword(ResetPasswordRequest request) throws Exception {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        if (user == null || user.isDeleted()) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("User email not found")
                    .build();
        }
        PasswordResetToken token = passwordResetTokenRepository.findByToken(request.getResetToken())
                .orElse(null);
        if (token == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .message("token not found")
                    .build();
        }

        if (token.getExpireTime().isBefore(OffsetDateTime.now())) {
            return CommonResponse.builder()
                    .code(CommonResponse.TOKEN_IS_EXPIRED)
                    .message("Token expired")
                    .build();
        }

        if (!StringUtils.equals(request.getNewPassword(), request.getNewPasswordConfirm())) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_BUSINESS)
                    .message("Password not match")
                    .build();
        }

        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        user.setPasswordExpiredAt(OffsetDateTime.now().plusDays(Constants.PASSWORD_EXPIRE_DAYS));
        this.userRepository.saveAndFlush(user);

        token.setStatus(RsTokenStatus.USED);
        this.passwordResetTokenRepository.saveAndFlush(token);

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(true)
                .build();
    }

    @Override
    public CommonResponse getPasswordTokenReset(String token) {
        PasswordResetToken pwToken = passwordResetTokenRepository.findByToken(token).orElse(null);
        if (pwToken == null) {
            return CommonResponse.builder()
                    .code(CommonResponse.CODE_NOT_FOUND)
                    .data(null)
                    .build();
        }

        if (pwToken.getExpireTime().isBefore(OffsetDateTime.now())) {
            pwToken.setStatus(RsTokenStatus.EXPIRED);
            passwordResetTokenRepository.save(pwToken);
        }
        ResetPasswordTokenDto resetPasswordTokenDto = ResetPasswordTokenDto.fromEntity(pwToken);
        userRepository.findById(resetPasswordTokenDto.getUserId()).ifPresent(user -> resetPasswordTokenDto.setUserLoginId(user.getUsername()));

        return CommonResponse.builder()
                .code(CommonResponse.CODE_SUCCESS)
                .data(resetPasswordTokenDto)
                .build();
    }
}
