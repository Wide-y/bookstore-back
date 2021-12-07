package com.springboot.bookstore.daoImpl;

import com.springboot.bookstore.dao.CartDao;
import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.model.BookItem;
import com.springboot.bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCCartlist(Integer userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Cart getItem(Integer userId, Integer bookId) {
        return cartRepository.findByUserIdAndBookId(userId, bookId);
    }

    @Override
    public Cart saveItem(Cart newItem) {
        return cartRepository.save(newItem);
    }

    @Override
    public Integer updateItem(Integer id, Integer num) {
        return cartRepository.updateCartNum(id, num);
    }

    @Override
    public void deleteItem(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void deleteItems(List<Cart> cartList) {
        for (Cart cart : cartList) {
            cartRepository.delete(cart);
        }
    }
}
