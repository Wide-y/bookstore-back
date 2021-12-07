package com.springboot.bookstore.daoImpl;

import com.springboot.bookstore.dao.OrderItemDao;
import com.springboot.bookstore.entity.OrderItem;
import com.springboot.bookstore.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getOrderItems(Integer listId) {
        return orderItemRepository.findByListId(listId);
    }

    @Override
    public List<OrderItem> saveItems(List<OrderItem> items) {
        return orderItemRepository.saveAll(items);
    }
}
