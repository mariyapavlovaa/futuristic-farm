package com.uni.fmi.futuristicfarm.service.userrole;

import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;

public interface UserRoleService {

    UserRoleDto createUserRole(UserRoleDto roleDto);

    UserRoleDto findByRoleId(Long roleId);
}
