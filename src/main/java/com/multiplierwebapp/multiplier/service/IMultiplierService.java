package com.multiplierwebapp.multiplier.service;

import com.multiplierwebapp.multiplier.dto.MultiplierResponse;
import com.multiplierwebapp.multiplier.model.MultiplierData;
import org.springframework.http.ResponseEntity;

public interface IMultiplierService {
    public ResponseEntity<MultiplierResponse> multiplierService(long num);
}
