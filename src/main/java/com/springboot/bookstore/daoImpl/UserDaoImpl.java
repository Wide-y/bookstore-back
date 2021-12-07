package com.springboot.bookstore.daoImpl;

import com.springboot.bookstore.dao.UserDao;
import com.springboot.bookstore.entity.*;
import com.springboot.bookstore.model.User;
import com.springboot.bookstore.repository.UserAuthRepository;
import com.springboot.bookstore.repository.UserDBRepository;
import com.springboot.bookstore.repository.UserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMysqlRepository userMysqlRepository;

    @Autowired
    private UserDBRepository userDBRepository;

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setValue(userMysqlRepository.getOne(id), userDBRepository.findByUserId(id).get());
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        List<UserMysql> userMysqls = userMysqlRepository.getAllUsers();
        for (UserMysql userMysql : userMysqls) {
            User user = new User();
            UserDB userDB = userDBRepository.findByUserId(userMysql.getUserId()).get();
            user.setValue(userMysql, userDB);
            users.add(user);
        }
        return users;
    }

    @Override
    public Integer updateUserType(Integer id, Integer type) {
        return userMysqlRepository.updateUserType(id, type);
    }

    @Override
    public UserAuth getAuth(String username) {
        return userAuthRepository.getAuth(username);
    }

    @Override
    public UserAuth addAccount(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public void addUser(User user) {
        userMysqlRepository.save(user.getUserMysql());
        userDBRepository.save(user.getUserDB());
    }
}
