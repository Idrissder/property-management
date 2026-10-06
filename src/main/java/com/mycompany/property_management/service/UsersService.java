package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDto;

public interface UsersService {
    UserDto register(UserDto userDto);
    UserDto login(String email, String password);
}
