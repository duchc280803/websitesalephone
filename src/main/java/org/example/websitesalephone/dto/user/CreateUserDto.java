package org.example.websitesalephone.dto.user;

import lombok.Builder;
import lombok.Data;
import org.example.websitesalephone.entity.User;
import org.example.websitesalephone.utils.Constants;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.OffsetDateTime;

@Data
@Builder
public class CreateUserDto {

    private String id;

    private String loginId;

    private String fullName;

    private String profileImg;

    private String email;

    private String telNo;

    private String userCode;

    private String note;

    private String password;

    private RoleDto roleDto;

    public static User toEntity(CreateUserDto dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getLoginId())
                .fullName(dto.getFullName() == null ? null : dto.getFullName().trim())
                .email(dto.getEmail())
                .description(dto.getNote())
                .passwordHash(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()))
                .passwordExpiredAt(OffsetDateTime.now().plusDays(Constants.PASSWORD_EXPIRE_DAYS))
                .codeUser(dto.getUserCode())
                .avatar(dto.getProfileImg())
                .build();
    }
}
