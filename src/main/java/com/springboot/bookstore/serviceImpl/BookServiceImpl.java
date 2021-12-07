package com.springboot.bookstore.serviceImpl;

import com.springboot.bookstore.dao.BookDao;
import com.springboot.bookstore.model.Book;
import com.springboot.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookDao.getBooksByName(name);
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookDao.deleteBook(bookId);
    }
}
