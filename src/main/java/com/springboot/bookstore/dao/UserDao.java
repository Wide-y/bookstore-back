package com.springboot.bookstore.dao;

import com.springboot.bookstore.entity.*;
import com.springboot.bookstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User findById(Integer id);
    UserAuth getAuth(String username);
    List<User> getUsers();
    Integer updateUserType(Integer id,Integer type);
    UserAuth addAccount(UserAuth userAuth);
    void addUser(User user);
}
