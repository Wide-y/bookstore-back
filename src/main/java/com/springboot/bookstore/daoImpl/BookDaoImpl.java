package com.springboot.bookstore.daoImpl;

import com.springboot.bookstore.dao.BookDao;
import com.springboot.bookstore.entity.BookDB;
import com.springboot.bookstore.entity.BookMysql;
import com.springboot.bookstore.model.Book;
import com.springboot.bookstore.repository.BookDBRepository;
import com.springboot.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDBRepository bookDBRepository;

    @Override
    public Book findOne(Integer id) {
        Book book = new Book();
        BookMysql bookMysql = bookRepository.getOne(id);
        BookDB bookDB = bookDBRepository.findByBookId(id).get();
        book.setBook(bookMysql, bookDB);
        return book;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        List<BookMysql> bookMysqlList = bookRepository.getBooks();

        for (BookMysql bookMysql : bookMysqlList) {
            Book book = new Book();
            BookDB bookDB = bookDBRepository.findByBookId(bookMysql.getBookID()).get();
            book.setBook(bookMysql, bookDB);
            books.add(book);
            System.out.println(book);
        }
        return books;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        List<Book> books = new ArrayList<>();
        List<BookMysql> bookMysqlList = bookRepository.getBooksByName(name);
        for (BookMysql bookMysql : bookMysqlList) {
            Book book = new Book();
            BookDB bookDB = bookDBRepository.findByBookId(bookMysql.getBookID()).get();
            book.setBook(bookMysql, bookDB);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book addBook(Book book) {
        BookMysql bookMysql = book.getBookMysql();

        BookMysql newBookM = bookRepository.save(bookMysql);
        BookDB bookDB = book.getBookDB(newBookM.getBookID());

        Optional<BookDB> newBookD = bookDBRepository.findByBookId(newBookM.getBookID());
        BookDB result;
        if (newBookD.isPresent()){
            bookDBRepository.deleteByBookId(newBookD.get().getBookId());
            result = bookDBRepository.save(bookDB);
        }
        else result = bookDBRepository.save(bookDB);


        Book newBook = new Book();
        newBook.setBook(newBookM, result);

        return newBook;
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
        bookDBRepository.deleteByBookId(id);
    }

    @Override
    public Integer updateInventory(Integer id,Integer inventory){
        bookRepository.updateBookInventory(id,inventory);
        return 1;
    }
}
