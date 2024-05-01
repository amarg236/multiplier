package com.multiplierwebapp.multiplier.controller;


import com.multiplierwebapp.multiplier.service.IMultiplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    IMultiplierService multiplierService;

    @PostMapping("multiply")
    public String home(@RequestParam("num") int num ){
        System.out.println(num);
        return multiplierService.multiplierService(num);


    }


}
