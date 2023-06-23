package com.uni.fmi.futuristicfarm.service.user;

import com.uni.fmi.futuristicfarm.mapper.user.UserMapper;
import com.uni.fmi.futuristicfarm.mapper.user.UserMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.userrole.UserRoleMapper;
import com.uni.fmi.futuristicfarm.mapper.userrole.UserRoleMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;
import com.uni.fmi.futuristicfarm.persistence.repository.user.UserRepository;
import com.uni.fmi.futuristicfarm.persistence.repository.userrole.UserRoleRepository;
import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.rest.dto.userrole.UserRoleDto;
import com.uni.fmi.futuristicfarm.service.userrole.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final UserMapper userMapper;
    private final UserRoleServiceImpl userRoleService;
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleServiceImpl userRoleService,
                           UserRoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.roleRepository = roleRepository;
        userMapper = new UserMapperImpl();
        userRoleMapper = new UserRoleMapperImpl();
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userDto == null) {
            throw new IllegalArgumentException("UserDto can't be null!");
        }

        User userEntity = userMapper.convertDtoToEntity(userDto);

        UserRoleDto userRoleDto = userRoleService.findByRoleId(userDto.getRole().getId());
        userEntity.setRole(userRoleMapper.convertDtoToEntity(userRoleDto));

        User user = userRepository.saveAndFlush(userEntity);

        return userMapper.convertEntityToDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {

        if (userId == null) {
            throw new IllegalArgumentException("UserId can't be null! ");
        }

        if (userDto == null) {
            throw new IllegalArgumentException("UserDto can't be null! ");
        }

        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "user", userId));
        }

        User user = existingUser.get();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        UserRoleDto userRoleDto = userRoleService.findByRoleId(userDto.getRole().getId());
        user.setRole(userRoleMapper.convertDtoToEntity(userRoleDto));

        User savedUser = userRepository.saveAndFlush(user);
        return userMapper.convertEntityToDto(savedUser);
    }

    @Override
    public UserDto deleteUser(Long userId) {

        if (userId == null) {
            throw new IllegalArgumentException("Id can't have null value! ");
        }

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found by given userId");
        }

        User existingUser = optionalUser.get();
        existingUser.setIsDeleted(true);

        User deletedUser = userRepository.saveAndFlush(existingUser);
        return userMapper.convertEntityToDto(deletedUser);
    }

    @Override
    public UserDto findUserByUserId(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with such id!"));

        return userMapper.convertEntityToDto(user);
    }

    @Override
    public UserDto findUserByUsername(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with such username!"));

        return userMapper.convertEntityToDto(user);

    }

    @Override
    public List<UserDto> findUsersByUserRole(UserRoleDto userRoleDto) {

        if (userRoleDto == null) {
            throw new IllegalArgumentException("UserRoleDto can't be null!");
        }

        List<User> userList = userRepository.findByRole(
                userRoleMapper.convertDtoToEntity(userRoleDto));

        return userList.stream()
                .map(userMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserByUsernameAndPassword(String username, String password) {

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password can't have null value!");
        }

        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));

        return userMapper.convertEntityToDto(user);
    }

    @Override
    public List<UserDto> findAllUsers() {

        List<User> userList = userRepository.findAll();

        return userList.stream()
                .map(userMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

}
