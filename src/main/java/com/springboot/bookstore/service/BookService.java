package com.springboot.bookstore.service;

import com.springboot.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Integer id);
    List<Book> getBooks();
    List<Book> getBooksByName(String name);
    Book addBook(Book book);
    void deleteBook(Integer bookId);
}
