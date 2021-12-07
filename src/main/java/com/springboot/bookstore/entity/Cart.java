package com.springboot.bookstore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "num")
    private int num;
}
