package com.uni.fmi.futuristicfarm.mapper.userrole;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole.UserRole;
import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleMapper {

    UserRoleMapper MAPPER = Mappers.getMapper(UserRoleMapper.class);

    UserRole convertDtoToEntity(UserRoleDto userRole);

    UserRoleDto convertEntityToDto(UserRole userRole);
}