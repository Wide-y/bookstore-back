package com.springboot.bookstore.service;

import com.springboot.bookstore.model.User;

import java.util.List;


public interface UserService {
    User findById(Integer id);
    List<User> getUsers();
    Integer updateUserType(Integer id,Integer type);
    Integer checkLog(String username, String password);
    Integer addAccount(String username, String password,String email);
}
