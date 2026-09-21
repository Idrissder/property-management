package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy}")
    private String dummy;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
        System.out.println("@ service layer HERE "+ propertyDto.getId());

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDto);
        pe =propertyRepository.save(pe);

        propertyDto = propertyConverter.convertEntitytoDTO(pe);
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAllProperties() {

        System.out.println("Inside Service "+ dummy);
        System.out.println("Inside Service "+ dbUrl);
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDto> propList = new ArrayList<>();
        for(PropertyEntity pe : listOfProps){
            PropertyDto dto = propertyConverter.convertEntitytoDTO(pe);
            propList.add(dto);
        }

        return propList;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto =null;
        if(optEn.isPresent()){

            PropertyEntity pe = optEn.get();//data from database
            pe.setTitle(propertyDto.getTitle());
            pe.setAddress(propertyDto.getAddress());
            pe.setOwnerEmail(propertyDto.getOwnerEmail());
            pe.setOwnerName(propertyDto.getOwnerName());
            pe.setPrice(propertyDto.getPrice());
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();//data from database
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyPrice(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();//data from database
            pe.setPrice(propertyDto.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
