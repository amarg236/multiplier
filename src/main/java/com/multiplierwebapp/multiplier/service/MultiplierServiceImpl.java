package com.multiplierwebapp.multiplier.service;

import com.multiplierwebapp.multiplier.dto.BaseResponse;
import com.multiplierwebapp.multiplier.dto.MultiplierResponse;
import com.multiplierwebapp.multiplier.model.MultiplierData;
import com.multiplierwebapp.multiplier.repo.MultiplierRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MultiplierServiceImpl implements IMultiplierService{

    @Autowired
    MultiplierRepo multiplierRepo;

    public ResponseEntity<MultiplierResponse> multiplierService(long num){


        try{
            log.info("Checking if number is greater than 0");
            if(num < 0){
                BaseResponse errorResponse = new BaseResponse("Number should be greater than 0",HttpStatus.BAD_REQUEST.value());
                MultiplierResponse multiplierResponse = new MultiplierResponse();
                multiplierResponse.setBaseResponse(errorResponse);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(multiplierResponse);
            }

            long multiplyBy2 = num * 2;
            log.info("Number multiplied by 2: "+multiplyBy2);


            long multiplyBy2Square = (long) Math.pow(multiplyBy2, 2);
            log.info("Number multiplied by 2 and squared: "+multiplyBy2Square);


            MultiplierData multiplierData = new MultiplierData();
            multiplierData.setNum(num);
            multiplierData.setMultiplyBy2(multiplyBy2);
            multiplierData.setMultiplyBy2Square(multiplyBy2Square);
            log.info("Storing data in database");
            multiplierRepo.save(multiplierData);
            log.info("Data stored in database");

            return ResponseEntity.ok(new MultiplierResponse(new BaseResponse("Success",HttpStatus.OK.value()),num,multiplyBy2,multiplyBy2Square));

        }
    catch (ArithmeticException e) {
            log.warn("Arithmetic exception occurred for number :"+num+ "error"+e.getMessage());
            MultiplierResponse errorResponse = new MultiplierResponse(new BaseResponse("Arithmetic exception occurred",HttpStatus.INTERNAL_SERVER_ERROR.value()),num,0,0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    } catch (NullPointerException e) {
            log.warn("Null pointer exception occurred :"+num+ "error"+e.getMessage());
            MultiplierResponse errorResponse = new MultiplierResponse(new BaseResponse("Null pointer exception occurred",HttpStatus.INTERNAL_SERVER_ERROR.value()),num,0,0);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    } catch (DataAccessException e) {
            log.warn("Data access exception occurred :"+num+ "error"+e.getMessage());
            MultiplierResponse errorResponse = new MultiplierResponse(new BaseResponse("Data access exception occurred",HttpStatus.INTERNAL_SERVER_ERROR.value()),num,0,0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    } catch (Exception e) {
            log.warn("Unexpected exception occurred :"+num+ "error"+e.getMessage());
            MultiplierResponse errorResponse = new MultiplierResponse(new BaseResponse("Unexpected exception occurred",HttpStatus.INTERNAL_SERVER_ERROR.value()),num,0,0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


    }
}
