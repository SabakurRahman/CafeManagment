package com.inn.sabakur.com.inn.cafe.service;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserService {
     ResponseEntity<String> signup(Map<String, String> requestMap);
}
