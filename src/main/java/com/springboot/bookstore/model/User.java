package com.springboot.bookstore.model;

import com.springboot.bookstore.entity.UserDB;
import com.springboot.bookstore.entity.UserMysql;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer userId;
    private String nickname;
    private String name;
    private String email;
    private Integer userType;
    private List<String> tel;
    private List<String> address;
    private String avatarBase64;

    public void setValue(UserMysql userMysql, UserDB userDB) {
        this.setUserId(userMysql.getUserId());
        this.setNickname(userMysql.getNickname());
        this.setName(userMysql.getName());
        this.setEmail(userMysql.getEmail());
        this.setUserType(userMysql.getUserType());
        this.setAddress(userDB.getAddressList());
        this.setTel(userDB.getTel());
        this.setAvatarBase64(userDB.getAvatarBase64());
    }
    public UserMysql getUserMysql(){
        UserMysql userMysql=new UserMysql();
        userMysql.setUserId(this.userId);
        userMysql.setName(this.name);
        userMysql.setNickname(this.nickname);
        userMysql.setEmail(this.email);
        userMysql.setUserType(this.userType);
        return userMysql;
    }
    public UserDB getUserDB(){
        UserDB userDB = new UserDB();
        userDB.setUserId(this.userId);
        userDB.setAddressList(this.address);
        userDB.setAvatarBase64(this.avatarBase64);
        userDB.setTel(this.tel);
        return userDB;
    }
}
