package com.inn.sabakur.com.inn.cafe.dao;

import com.inn.sabakur.com.inn.cafe.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

   //@Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
   User findByEmail(String emailId);
}
