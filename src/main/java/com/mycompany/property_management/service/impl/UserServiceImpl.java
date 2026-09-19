package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto saveUserData(UserDto userDto) {
        // Business logic happens here
        System.out.println("Processing user: " + userDto.getName());
        return null;
    }
}
