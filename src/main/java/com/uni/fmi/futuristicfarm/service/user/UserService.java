package com.uni.fmi.futuristicfarm.service.user;

import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long userId, UserDto userDto);

    UserDto deleteUser(Long useId);

    UserDto findUserByUserId(Long userId);

    UserDto findUserByUsername(String username);

    List<UserDto> findUsersByUserRole(UserRoleDto userRoleDto);

    UserDto findUserByUsernameAndPassword(String username, String password);

    List<UserDto> findAllUsers();
}
