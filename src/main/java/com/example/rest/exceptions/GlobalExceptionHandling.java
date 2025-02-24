package com.example.rest.exceptions;

import com.example.rest.rsponsehandler.ResponseHandler;
import com.example.rest.trainee.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> exceptionhandler(){
        return ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Id not found", null);

    }
}
