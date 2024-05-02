package com.multiplierwebapp.multiplier.controller;


import com.multiplierwebapp.multiplier.dto.BaseResponse;
import com.multiplierwebapp.multiplier.dto.MultiplierResponse;
import com.multiplierwebapp.multiplier.model.MultiplierData;
import com.multiplierwebapp.multiplier.service.IMultiplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class MainController {

    @Autowired
    IMultiplierService multiplierService;

    @PostMapping("multiply")
    public ResponseEntity<MultiplierResponse> home(@RequestParam("num") String num ){
        try{
            Long number = Long.parseLong(num);
            log.info("Request received for number: "+num);
            return multiplierService.multiplierService(number);

        }catch (NumberFormatException e) {
            log.error("Error occurred: "+e.getMessage());
            BaseResponse errorResponse = new BaseResponse("Number should be a valid number", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MultiplierResponse(errorResponse,0,0,0));
        }



    }


}
