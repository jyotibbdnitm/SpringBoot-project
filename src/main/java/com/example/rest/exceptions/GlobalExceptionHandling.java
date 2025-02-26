package com.example.rest.exceptions;

import com.example.rest.rsponsehandler.ResponseHandler;
import com.example.rest.trainee.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> exceptionhandler(){
        return ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Id not found", null);

    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, Object> handleArgumentException(MethodArgumentNotValidException ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timeStamp", System.currentTimeMillis());
        map.put("Status", HttpStatus.BAD_REQUEST.value());
        map.put("Error",
                 ex
                .getBindingResult()
                .getAllErrors()
                         .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())
        );

                 return map;
    }
        @ExceptionHandler(value = {Exception.class})
        public ResponseEntity<Object> Exceptionhandle () {
            return ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Exception", null);

        }


}
