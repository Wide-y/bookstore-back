package com.springboot.bookstore.repository;

import com.springboot.bookstore.model.BookItem;
import com.springboot.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUserIdAndBookId(Integer userId, Integer bookId);

    List<Cart> findByUserId(Integer userId);

    @Transactional
    @Modifying
    @Query("update Cart c set c.num = :num where c.id = :id")
    Integer updateCartNum(@Param("id") Integer id, @Param("num") Integer num);
}
