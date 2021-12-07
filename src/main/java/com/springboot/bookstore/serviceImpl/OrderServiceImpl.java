package com.springboot.bookstore.serviceImpl;

import com.springboot.bookstore.dao.*;
import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.entity.OrderItem;
import com.springboot.bookstore.entity.OrderList;
import com.springboot.bookstore.model.*;
import com.springboot.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderListDao orderListDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<OrderList> getOrderList(Integer userId, Integer type, Integer admin) {
        List<OrderList> orderLists = admin == 1 ? orderListDao.getAllOrderList() : orderListDao.getOrderList(userId);
        if (type == 0)
            return orderLists;
        else {
            Date date = new Date();
            long d = 24 * 60 * 60 * 1000;
            switch (type) {
                case 1:
                    date.setTime(date.getTime() - 7 * d);
                    break;
                case 2:
                    date.setTime(date.getTime() - 30 * d);
                    break;
                case 3:
                    date.setTime(date.getTime() - 360 * d);
                    break;
            }

            orderLists.removeIf(orderList -> orderList.getDate().before(date));
            return orderLists;
        }
    }

    @Override
    public List<BookItem> getOrderItems(Integer listId) {
        List<OrderItem> orderItems = orderItemDao.getOrderItems(listId);
        List<BookItem> bookItems = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            BookItem bookItem = new BookItem(bookDao.findOne(orderItem.getBookId()), orderItem.getNum(), orderItem.getId());
            bookItems.add(bookItem);
        }
        return bookItems;
    }

    @Override
    public List<BookItem> getRanklist(Integer userId, Integer type, Integer admin) {
        List<OrderList> orderLists = this.getOrderList(userId, type, admin);
        List<BookItem> ranklist = new ArrayList<>();
        for (OrderList orderList : orderLists) {
            List<BookItem> orderItem = this.getOrderItems(orderList.getId());
            for (BookItem bookItem : orderItem) {
                int index = ranklist.indexOf(bookItem);
                if (index == -1) ranklist.add(bookItem);
                else {
                    Integer num = ranklist.get(index).getNum();
                    ranklist.get(index).setNum(num + bookItem.getNum());
                }
            }
        }
        int size = ranklist.size();
        List<BookItem> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = 0, max = 0;
            for (BookItem bookItem : ranklist) {
                if (bookItem.getNum() > max) {
                    max = bookItem.getNum();
                    index = ranklist.indexOf(bookItem);
                }
            }
            result.add(ranklist.get(index));
            ranklist.remove(index);
        }

        return result;
    }

    @Override
    public List<UserRank> getUserRank(Integer type) {
        List<UserRank> userRankList = new ArrayList<>();
        List<OrderList> orderLists = this.getOrderList(1, type, 1);
        for (OrderList orderList : orderLists) {
            User user = userDao.findById(orderList.getUserId());
            UserRank userRank = new UserRank(user, orderList.getTotPrice());
            int index = userRankList.indexOf(userRank);
            System.out.println(index);
            if (index == -1) {
                userRankList.add(userRank);
            } else {
                Double price = userRankList.get(index).getPrice();
                userRankList.get(index).setPrice(price + orderList.getTotPrice());
            }
        }
        int size = userRankList.size();
        List<UserRank> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int index = 0;
            Double max = 0.0;
            for (UserRank userRank : userRankList) {
                if (userRank.getPrice() > max) {
                    max = userRank.getPrice();
                    index = userRankList.indexOf(userRank);
                }
            }
            result.add(userRankList.get(index));
            userRankList.remove(index);
        }
        return result;
    }

    @Override
    public OrderList saveOrderList(OrderList newItem) {
        return orderListDao.saveOrderList(newItem);
    }

    @Override
    public List<OrderItem> saveOrderItem(List<OrderItem> orderItems) {
        return orderItemDao.saveItems(orderItems);
    }

    @Override
    public Integer saveOrder(Order order) {
        OrderList orderList = orderListDao.saveOrderList(order.getOrderList());
        List<Cart> cartList = order.getCartList();
        List<OrderItem> orderItems = order.generateOrderItems(orderList.getId());
        orderItemDao.saveItems(orderItems);
        cartDao.deleteItems(order.getCartList());
//        for (Cart cart : cartList) {
//            Book book = bookDao.findOne(cart.getBookId());
//            bookDao.updateInventory(cart.getBookId(), book.getInventory() - cart.getNum());
//        }
        return orderList.getId();
    }
}
