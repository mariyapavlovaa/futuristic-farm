package com.uni.fmi.futuristicfarm.service.userrole;

import com.uni.fmi.futuristicfarm.mapper.userrole.UserRoleMapper;
import com.uni.fmi.futuristicfarm.mapper.userrole.UserRoleMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole.UserRole;
import com.uni.fmi.futuristicfarm.persistence.repository.userrole.UserRoleRepository;
import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRoleMapper = new UserRoleMapperImpl();
    }

    @Override
    public UserRoleDto createUserRole(UserRoleDto userRoleDto) {

        if (userRoleDto == null) {
            throw new IllegalArgumentException("UserRoleDto can't be null! ");
        }

        UserRole userRole = userRoleRepository.saveAndFlush(userRoleMapper.convertDtoToEntity(userRoleDto));

        return userRoleMapper.convertEntityToDto(userRole);
    }

    @Override
    public UserRoleDto findByRoleId(Long roleId) {

        if (roleId == null) {
            throw new IllegalArgumentException("UserRoleDto can't be found with such id! ");
        }

        Optional<UserRole> userRole = userRoleRepository.findById(roleId);

        UserRole role = userRoleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        return userRoleMapper.convertEntityToDto(role);
    }
}
