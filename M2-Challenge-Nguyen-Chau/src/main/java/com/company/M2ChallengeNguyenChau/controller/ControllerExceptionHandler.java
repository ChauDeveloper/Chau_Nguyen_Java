package com.company.M2ChallengeNguyenChau.controller;


import com.company.M2ChallengeNguyenChau.exception.IllegalArgumentException;
import com.company.M2ChallengeNguyenChau.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ControllerExceptionHandler {

    //taken from bootcamp class on echo range exercise in Module 2
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> handleOutOfRange(IllegalArgumentException e){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }




}
