package com.uni.fmi.futuristicfarm.rest.dto.userrole;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;

public class UserRoleDto extends BaseDto {

    @NotBlank
    private String role;

    public UserRoleDto() {
    }

    public UserRoleDto(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
