package com.uni.fmi.futuristicfarm.mapper.user;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;
import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "isDeleted", ignore = true)
    @Mapping(source = "role.role", target = "role.role")
    @Mapping(source = "role.id", target = "role.id")
    User convertDtoToEntity(UserDto userDto);

    @Mapping(source = "role.role", target = "role.role")
    UserDto convertEntityToDto(User user);
}
