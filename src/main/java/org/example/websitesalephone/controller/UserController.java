package org.example.websitesalephone.controller;

import lombok.RequiredArgsConstructor;
import org.example.websitesalephone.comon.CommonResponse;
import org.example.websitesalephone.dto.user.CreateUserDto;
import org.example.websitesalephone.dto.user.UserSearchForm;
import org.example.websitesalephone.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("get-user-by-login/{loginId}")
    public CommonResponse getUserByLoginId(@PathVariable(name = "loginId") String loginId) {
        return userService.getUserByLoginId(loginId);
    }

    @PostMapping("create")
    public CommonResponse createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PutMapping("update")
    public CommonResponse updateUser(CreateUserDto createUserDto) {
        return userService.updateUser(createUserDto);
    }

    @PutMapping("delete/{userId}")
    public CommonResponse deleteUser(@PathVariable(name = "userId") String userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping("search")
    public CommonResponse search(@RequestBody UserSearchForm searchForm) {
        return userService.search(searchForm);
    }
}
