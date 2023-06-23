package com.uni.fmi.futuristicfarm.rest.dto.user;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;
import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;

import javax.validation.constraints.NotBlank;

public class UserDto extends BaseDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    private UserRoleDto role;

    public UserDto() {
    }

    public UserDto(String username,
                   String password,
                   String firstName,
                   String lastName,
                   String email,
                   UserRoleDto role) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

}
