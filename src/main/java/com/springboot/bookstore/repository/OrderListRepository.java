package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    List<OrderList> findByUserId(Integer userId);
}
