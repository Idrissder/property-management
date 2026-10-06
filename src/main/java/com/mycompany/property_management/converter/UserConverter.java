package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDto.getOwnerEmail());
        userEntity.setOwnerName(userDto.getOwnerName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setPhone(userDto.getPhone());
        return userEntity;
    }

    public UserDto convertEntityToDTO(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        userDto.setOwnerName(userEntity.getOwnerName());
//        userDto.setPassword(userEntity.getPassword());
        userDto.setPhone(userEntity.getPhone());
        return userDto;
    }
}
