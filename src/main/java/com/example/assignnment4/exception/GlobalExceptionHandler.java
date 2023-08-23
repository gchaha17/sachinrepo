package com.example.assignnment4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestrictedInfo.class)
    public ResponseEntity<String> infoError(RestrictedInfo ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST );
    }
    /*@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> nosuchElement()
    {
        return new ResponseEntity<>("no element foung", HttpStatus.BAD_GATEWAY);

    }*/
}