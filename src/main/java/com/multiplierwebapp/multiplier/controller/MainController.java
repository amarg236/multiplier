package com.multiplierwebapp.multiplier.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainController {


    public String home(){
        return "Welcome to the Multiplier Web App";
    }


}
