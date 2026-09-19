package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PropertyController {

    @Value("${pms.dummy}")
    private String dummy;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    PropertyService propertyService;

    //RESTFUL API is just mapping of a url to a java class function
    //http://localhost:8080/api/v1/properties/hello
    @GetMapping("/hello")
    public String sayHello(){
        return "HELLO";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto){

        propertyDto=propertyService.saveProperty(propertyDto);
        System.out.println(propertyDto);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>>getAllProperties(){
        System.out.println(dummy);
        System.out.println(dbUrl);
        List<PropertyDto> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId){
        propertyDto = propertyService.updateProperty(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;


    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId){
        propertyDto = propertyService.updatePropertyDescription(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return responseEntity;

    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyPrice(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId){
        propertyDto = propertyService.updatePropertyPrice(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return responseEntity;
    }


    }
