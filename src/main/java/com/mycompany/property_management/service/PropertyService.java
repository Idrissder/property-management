package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

     PropertyDto saveProperty(PropertyDto propertyDto);
     List<PropertyDto> getAllProperties();
     PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);
     PropertyDto updatePropertyDescription(@RequestBody PropertyDto propertyDto, Long propertyId);
     PropertyDto updatePropertyPrice(@RequestBody PropertyDto propertyDto, Long propertyId);
     void deleteProperty(Long propertyId);

}
