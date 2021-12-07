package com.springboot.bookstore.model;

import lombok.Data;

@Data
public class BookItem {
    private Book book;
    private Integer itemId;
    private Integer num;

    public BookItem(Book book, Integer num, Integer itemId) {
        this.book = book;
        this.num = num;
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BookItem) {
            return this.book.getBookID() == ((BookItem) obj).book.getBookID();
        } else return false;
    }
}
