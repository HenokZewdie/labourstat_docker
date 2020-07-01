package com.restapi.laborstats;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<Error> handleBadRequestException(BadRequestException e){
        return new ResponseEntity<>(errorPayLoad(e.errorCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private Error errorPayLoad(String errorCode, String message) {
        return new Error().error(new ErrorType().code(errorCode).description(message));
    }
}
