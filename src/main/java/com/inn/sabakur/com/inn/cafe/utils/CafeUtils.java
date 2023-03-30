package com.inn.sabakur.com.inn.cafe.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {

    private CafeUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessge, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessge+"\"}",
              httpStatus);
    }
}
