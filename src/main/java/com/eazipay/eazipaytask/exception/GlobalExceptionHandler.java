package com.eazipay.eazipaytask.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleException(Exception ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message", ex.getMessage());
        return errorMap;
        };

}


