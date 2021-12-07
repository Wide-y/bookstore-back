package com.springboot.bookstore.dao;

import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.model.BookItem;

import java.util.List;

public interface CartDao {
    List<Cart> getCCartlist(Integer userId);

    Cart getItem(Integer userId, Integer bookId);

    Cart saveItem(Cart newItem);

    Integer updateItem(Integer id, Integer num);

    void deleteItem(Integer id);

    void deleteItems(List<Cart> cartList);
}
