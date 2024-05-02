package com.multiplierwebapp.multiplier.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiplierResponse {
    private BaseResponse baseResponse;
    private long num;
    private long multiplyBy2;
    private long multiplyBy2Square;
}
