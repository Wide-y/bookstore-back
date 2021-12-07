package com.springboot.bookstore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "list_id")
    private Integer listId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "num")
    private Integer num;

}
