package com.springboot.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orderList")
@EntityListeners(AuditingEntityListener.class)
public class OrderList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "tot_price")
    private Double totPrice;

    @Column(name = "datetime")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String tel;

    @Column(name = "item_num")
    private Integer itemNum;

    @Column(name = "index_book")
    private String indexBook;

    @Column(name = "name")
    private String name;
}
