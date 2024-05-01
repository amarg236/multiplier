package com.multiplierwebapp.multiplier.service;

import org.springframework.stereotype.Service;

@Service
public class MultiplierServiceImpl implements IMultiplierService{
    public String multiplierService(int num){
        return "this is service";
    }
}
