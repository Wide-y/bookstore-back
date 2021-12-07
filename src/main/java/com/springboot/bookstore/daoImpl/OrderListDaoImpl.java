package com.springboot.bookstore.daoImpl;

import com.springboot.bookstore.dao.OrderListDao;
import com.springboot.bookstore.entity.OrderList;
import com.springboot.bookstore.repository.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderListDaoImpl implements OrderListDao {
    @Autowired
    private OrderListRepository orderListRepository;

    @Override
    public List<OrderList> getOrderList(Integer userId) {
        return orderListRepository.findByUserId(userId);
    }

    @Override
    public OrderList saveOrderList(OrderList newOrd) {
        return orderListRepository.save(newOrd);
    }

    @Override
    public List<OrderList> getAllOrderList(){
        return orderListRepository.findAll();
    }
}
