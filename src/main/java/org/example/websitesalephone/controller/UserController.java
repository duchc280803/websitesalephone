package org.example.websitesalephone.controller;

import lombok.RequiredArgsConstructor;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.dto.user.CreateUserDto;
import org.example.websitesalephone.dto.user.UserSearchForm;
import org.example.websitesalephone.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public CommonResponse getUserByLoginId(String loginId) {
        return userService.getUserByLoginId(loginId);
    }

    public CommonResponse createUser(CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    public CommonResponse updateUser(CreateUserDto createUserDto) {
        return userService.updateUser(createUserDto);
    }

    public CommonResponse deleteUser(String userId) {
        return userService.deleteUser(userId);
    }

    public CommonResponse search(UserSearchForm searchForm) {
        return userService.search(searchForm);
    }
}
