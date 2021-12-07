package com.springboot.bookstore.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "book")
@Data

public class BookMysql {
    public BookMysql() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int bookID;

    private String isbn;
    private String name;
    private String type;
    private String author;
    private Double price;
    private Integer inventory;
}
