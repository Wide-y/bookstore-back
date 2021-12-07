package com.springboot.bookstore.controller;

import com.springboot.bookstore.model.Book;
import com.springboot.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:47516"})
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/getBooks")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping("/getBook")
    public Book getBook(@RequestParam("id") Integer id) {
        return bookService.findBookById(id);
    }

    @RequestMapping("/getBooksByName")
    public List<Book> getBkkosByName(@RequestParam("name") String name) {
        return bookService.getBooksByName(name);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        System.out.println("book");
        System.out.println(book);
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public Integer deleteBook(@RequestParam("bookId") Integer bookId) {
        bookService.deleteBook(bookId);
        return 1;
    }
}
