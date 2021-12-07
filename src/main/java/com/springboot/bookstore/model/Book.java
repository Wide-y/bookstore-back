package com.springboot.bookstore.model;

import com.springboot.bookstore.entity.BookDB;
import com.springboot.bookstore.entity.BookMysql;
import lombok.Data;

@Data
public class Book {
    private int bookID;

    private String isbn;
    private String name;
    private String type;
    private String author;
    private Double price;
    private Integer inventory;
    private String description;
    private String imgBase64;

    public void setBook(BookMysql bookMysql, BookDB bookDB) {
        this.setBookID(bookMysql.getBookID());
        this.setIsbn(bookMysql.getIsbn());
        this.setName(bookMysql.getName());
        this.setType(bookMysql.getType());
        this.setAuthor(bookMysql.getAuthor());
        this.setPrice(bookMysql.getPrice());
        this.setInventory(bookMysql.getInventory());
        this.setDescription(bookDB.getDescription());
        this.setImgBase64(bookDB.getImgBase64());
    }

    public BookMysql getBookMysql() {
        BookMysql bookMysql = new BookMysql();
        bookMysql.setBookID(this.bookID);
        bookMysql.setName(this.name);
        bookMysql.setAuthor(this.author);
        bookMysql.setInventory(this.inventory);
        bookMysql.setIsbn(this.isbn);
        bookMysql.setPrice(this.price);
        bookMysql.setType(this.type);
        return bookMysql;
    }
    public BookDB getBookDB(Integer bookID){
        BookDB bookDB = new BookDB();
        bookDB.setBookId(bookID);
        bookDB.setDescription(this.description);
        bookDB.setImgBase64(this.imgBase64);
        return bookDB;
    }
}
