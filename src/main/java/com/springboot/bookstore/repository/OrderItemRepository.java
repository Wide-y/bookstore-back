package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByListId(Integer listId);
}
