package com.springboot.bookstore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "user")
public class UserMysql {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "nickname")
    private String nickname;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "user_type")
    private Integer userType;

    public UserMysql() {
    }
}
