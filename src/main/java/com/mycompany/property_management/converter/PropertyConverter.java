package com.mycompany.property_management.converter;


import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDto propertyDto){

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDto.getTitle());
        pe.setAddress(propertyDto.getAddress());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setPrice(propertyDto.getPrice());
        pe.setDescription(propertyDto.getDescription());

        return pe;
    }

    public PropertyDto convertEntitytoDTO(PropertyEntity propertyEntity){

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setId(propertyEntity.getId());
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setAddress(propertyEntity.getAddress());
        propertyDto.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setDescription(propertyEntity.getDescription());

        return propertyDto;
    }
}
