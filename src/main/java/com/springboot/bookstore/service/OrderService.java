package com.springboot.bookstore.service;

import com.springboot.bookstore.entity.OrderItem;
import com.springboot.bookstore.entity.OrderList;
import com.springboot.bookstore.model.BookItem;
import com.springboot.bookstore.model.Order;
import com.springboot.bookstore.model.UserRank;

import java.util.List;

public interface OrderService {
    List<OrderList> getOrderList(Integer userId,Integer type,Integer admin);
    List<BookItem> getOrderItems(Integer listId);
    OrderList saveOrderList(OrderList newItem);
    List<OrderItem> saveOrderItem(List<OrderItem> orderItems);
    Integer saveOrder(Order order);
    List<BookItem> getRanklist(Integer userId,Integer type,Integer admin);
    List<UserRank> getUserRank(Integer type);
}
