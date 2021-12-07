package com.springboot.bookstore.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_auth")
public class UserAuth {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;

    private  String username;
    private String password;
    private int user_type;
}
