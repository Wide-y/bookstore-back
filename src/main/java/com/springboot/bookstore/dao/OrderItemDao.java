package com.springboot.bookstore.dao;

import com.springboot.bookstore.entity.OrderItem;

import java.util.List;

public interface OrderItemDao{
    List<OrderItem> getOrderItems(Integer listId);
    List<OrderItem> saveItems(List<OrderItem> items);
}
