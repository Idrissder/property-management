package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public UserDto saveUser(@RequestBody UserDto userDto){
        userService.saveUserData(userDto);
        System.out.println((userDto));
        return userDto;
    }

}
