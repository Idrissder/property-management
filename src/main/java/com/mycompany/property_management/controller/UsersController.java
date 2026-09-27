package com.mycompany.property_management.controller;


import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UsersController {

    @Autowired
    private UsersService usersServices;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){

        userDto = usersServices.register(userDto);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto, HttpStatus.CREATED);
        return responseEntity;
    }
}
