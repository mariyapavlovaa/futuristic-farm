package com.uni.fmi.futuristicfarm.rest.controller.user;

import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.service.user.UserService;
import com.uni.fmi.futuristicfarm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(Constants.API_V1 + Constants.USER)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findUserById(@PathVariable Long userId) {
        return userService.findUserByUserId(userId);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto login(@RequestParam String username, @RequestParam String password) {
        return userService.findUserByUsernameAndPassword(username, password);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    //TODO
    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable Long userId,
                              @Valid @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
