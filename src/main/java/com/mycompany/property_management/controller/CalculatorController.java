package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")//class level mapping of url to a controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    //http://localhost:8080/api/v1/calculator/add?num111=6.7&num222=1.3
    //http://localhost:8080/api/v1/calculator/add?num1=6.9&num2=13.8
    @GetMapping("/add/{num3}")//method level mapping of url to a controller class
    public Double add(@RequestParam("num13") Double num1,
                      @RequestParam("num23") Double num2,
                      @PathVariable("num3") Double num3){
        return num1+num2+num3;
    }

    @GetMapping("/sub/{num111}/{num2}")//Map the values of url to java variables by path variable method
    public Double substract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1-num2;
        }
        else{
            result = num2-num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDto calculatorDto){
        Double result = null;
        result = calculatorDto.getNum1()*calculatorDto.getNum2()*calculatorDto.getNum3()*calculatorDto.getNum4();
        return  result;
    }
}
