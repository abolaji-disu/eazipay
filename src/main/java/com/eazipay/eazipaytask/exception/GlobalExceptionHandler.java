package com.eazipay.eazipaytask.exception;

import graphql.GraphQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({UserNotFoundException.class , AppUserExistException.class})
    public Map<String, String> handleException(Exception ex){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message", ex.getMessage());
        return errorMap;
        };

    @ExceptionHandler(GraphQLException.class)
    public ResponseEntity<String> handleGraphQLException(GraphQLException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


