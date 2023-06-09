package com.inn.sabakur.com.inn.cafe.controller;

import com.inn.sabakur.com.inn.cafe.constents.CafeConstans;
import com.inn.sabakur.com.inn.cafe.service.UserService;
import com.inn.sabakur.com.inn.cafe.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap) {
        try{
            return userService.signup(requestMap);

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return CafeUtils.getResponseEntity(CafeConstans.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
