package com.inn.sabakur.com.inn.cafe.dao;

import com.inn.sabakur.com.inn.cafe.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
