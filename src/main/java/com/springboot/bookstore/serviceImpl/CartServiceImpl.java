package com.springboot.bookstore.serviceImpl;

import com.springboot.bookstore.dao.BookDao;
import com.springboot.bookstore.dao.CartDao;
import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.model.BookItem;
import com.springboot.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public List<BookItem> getCartlist(Integer userId) {
        List<Cart> carts = cartDao.getCCartlist(userId);
        List<BookItem> bookItems = new ArrayList<>();
        for (Cart cart : carts) {
            BookItem bookItem = new BookItem(bookDao.findOne(cart.getBookId()), cart.getNum(), cart.getId());
            bookItems.add(bookItem);
        }
        return bookItems;
    }

    @Override
    public Cart saveItem(Integer bookId, Integer userId, Integer num) {
        Cart cartItem = cartDao.getItem(userId,bookId);
        if(cartItem==null) {
            Cart newItem = new Cart();
            newItem.setUserId(userId);
            newItem.setBookId(bookId);
            newItem.setNum(num);
            return cartDao.saveItem(newItem);
        }
        else {
            cartDao.updateItem(cartItem.getId(),num+cartItem.getNum());
            cartItem.setNum(num);
            return cartItem;
        }
    }

    @Override
    public Integer updateItem(Integer id, Integer num) {
        return cartDao.updateItem(id, num);
    }

    @Override
    public void deleteItem(Integer id) {
        cartDao.deleteItem(id);
    }
}
