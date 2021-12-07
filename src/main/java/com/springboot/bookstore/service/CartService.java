package com.springboot.bookstore.service;

import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.model.BookItem;

import java.util.List;

public interface CartService {
    List<BookItem> getCartlist(Integer userId);

    Cart saveItem(Integer bookId, Integer userId, Integer num);

    Integer updateItem(Integer id, Integer num);

    void deleteItem(Integer id);
}
