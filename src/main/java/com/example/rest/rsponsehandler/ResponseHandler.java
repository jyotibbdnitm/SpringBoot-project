package com.example.rest.rsponsehandler;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> requestHandling(HttpStatus httpStatus, boolean isEroor, String message, Object body ){
        Map<String, Object> hashMap= new HashMap<String, Object>();
        try {
           hashMap.put("status", httpStatus.value());
           hashMap.put("error", isEroor);
           hashMap.put("messahe", message);
           hashMap.put("data", body);
           return new ResponseEntity<Object>(hashMap, httpStatus);
        } catch (Exception e){
            hashMap.put("status", httpStatus.INTERNAL_SERVER_ERROR);
            hashMap.put("error", false);
            hashMap.put("messahe", e.getMessage());
            hashMap.put("data", body);
            return new ResponseEntity<Object>(hashMap, httpStatus);
        }

    }
}
