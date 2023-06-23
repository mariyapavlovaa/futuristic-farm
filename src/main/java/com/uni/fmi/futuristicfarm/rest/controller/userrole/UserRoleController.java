package com.uni.fmi.futuristicfarm.rest.controller.userrole;

import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;
import com.uni.fmi.futuristicfarm.service.userrole.UserRoleService;
import com.uni.fmi.futuristicfarm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.API_V1 + Constants.USER_ROLE_PATH)
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping(value = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRoleDto findByRoleId(@PathVariable Long roleId) {

        return userRoleService.findByRoleId(roleId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRoleDto createUserRole(@Valid @RequestBody UserRoleDto userRoleDto) {

        return userRoleService.createUserRole(userRoleDto);
    }

}
