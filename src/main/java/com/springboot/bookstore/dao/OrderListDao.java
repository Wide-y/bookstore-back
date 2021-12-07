package com.springboot.bookstore.dao;

import com.springboot.bookstore.entity.OrderList;

import java.util.List;

public interface OrderListDao {
    List<OrderList> getOrderList(Integer userId);
    OrderList saveOrderList(OrderList newOrd);
    List<OrderList> getAllOrderList();
}
