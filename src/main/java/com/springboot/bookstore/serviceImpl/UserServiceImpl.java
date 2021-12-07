package com.springboot.bookstore.serviceImpl;

import com.springboot.bookstore.dao.UserDao;
import com.springboot.bookstore.entity.*;
import com.springboot.bookstore.model.User;
import com.springboot.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User
    findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public Integer updateUserType(Integer id, Integer type) {
        return userDao.updateUserType(id, type);
    }

    @Override
    public Integer checkLog(String username, String password) {
        UserAuth userInfo = userDao.getAuth(username);
        if (userInfo == null) return 0;
        if (password.equals(userInfo.getPassword())) {
            User user = userDao.findById(userInfo.getUserId());
            if (user.getUserType() != 0) return userInfo.getUserId();
            else return -1;
        } else return 0;
    }

    @Override
    public Integer addAccount(String username, String password, String email) {
        if (userDao.getAuth(username) != null) {
            return 0;
        } else {
            UserAuth userAuth = new UserAuth();
            userAuth.setUsername(username);
            userAuth.setPassword(password);
            userAuth.setUser_type(1);
            UserAuth authresp = userDao.addAccount(userAuth);
            System.out.println(authresp);
            User user = new User();
            user.setUserId(authresp.getUserId());
            user.setNickname(username);
            user.setName(username);
            user.setUserType(1);
            user.setEmail(email);
            List<String> blank = new ArrayList<>();
            user.setTel(blank);
            user.setAddress(blank);
            user.setAvatarBase64("");
            userDao.addUser(user);
            return 1;
        }
    }
}
