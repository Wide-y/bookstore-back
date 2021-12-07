package com.springboot.bookstore.dao;

import com.springboot.bookstore.entity.BookMysql;
import com.springboot.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    Book findOne(Integer id);
    List<Book> getBooks();
    List<Book> getBooksByName(String name);
    Book addBook(Book book);
    void deleteBook(Integer id);
    Integer updateInventory(Integer id,Integer inventory);
}
