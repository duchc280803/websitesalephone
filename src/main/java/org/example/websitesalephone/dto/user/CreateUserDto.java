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
        User user = new User();

        user.setId(dto.getId());
        user.setUsername(dto.getLoginId());
        user.setFullName(dto.getFullName() == null ? null : dto.getFullName().trim());
        user.setEmail(dto.getEmail());
        user.setDescription(dto.getNote());
        user.setPasswordHash(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt()));
        user.setPasswordExpiredAt(OffsetDateTime.now().plusDays(Constants.PASSWORD_EXPIRE_DAYS));
        user.setCodeUser(dto.getUserCode());
        user.setAvatar(dto.getProfileImg());

        return user;
    }
}
