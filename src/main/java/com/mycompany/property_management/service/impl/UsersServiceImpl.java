package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {

        UserEntity userEntity = userConverter.convertDTOtoEntity(userDto);
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntityToDTO(userEntity);

        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        return null;
    }
}

