package com.inn.sabakur.com.inn.cafe.serviceImpl;

import com.inn.sabakur.com.inn.cafe.POJO.User;
import com.inn.sabakur.com.inn.cafe.constents.CafeConstans;
import com.inn.sabakur.com.inn.cafe.dao.UserDao;
import com.inn.sabakur.com.inn.cafe.service.UserService;
import com.inn.sabakur.com.inn.cafe.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
   @Autowired
   UserDao userDao;


    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        log.info("Inside signup{}",requestMap);
       try {
           if (validateSignUPMap(requestMap)) {
               User user = userDao.findByEmail(requestMap.get("email"));

               if (Objects.isNull(user)) {
                   userDao.save(getUserFromMap(requestMap));
                   return CafeUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
               }
               else return CafeUtils.getResponseEntity(CafeConstans.EMAIL_ALREDY_EXIST,HttpStatus.BAD_REQUEST);

           } else {
               return CafeUtils.getResponseEntity(CafeConstans.INVALID_DATA, HttpStatus.BAD_REQUEST);
           }
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
       return CafeUtils.getResponseEntity(CafeConstans.SOMETHING_WENT_WRONG,HttpStatus.BAD_REQUEST);


    }

    private boolean validateSignUPMap(Map<String,String> requestMap){

       if( requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password")){
           return true;
        }
        return false;

    }
    private User getUserFromMap(Map<String,String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
