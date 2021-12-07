package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.BookMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<BookMysql, Integer> {
    @Query("select b from BookMysql b")
    List<BookMysql> getBooks();

    @Query("select b from BookMysql b where b.name like %?1%")
    List<BookMysql> getBooksByName(String name);

    @Query("update BookMysql b set b.name = :name where b.bookID=:id")
    BookMysql updateBookName(@Param("id") Integer id, @Param("name") String name);

    @Query("update BookMysql b set b.isbn = :isbn where b.bookID=:id")
    BookMysql updateBookIsbn(@Param("id") Integer id, @Param("isbn") Integer isbn);

    @Query("update BookMysql b set b.name = :author where b.bookID=:id")
    BookMysql updateBookAuthor(@Param("id") Integer id, @Param("author") String author);

    @Query("update BookMysql b set b.inventory = :inventory where b.bookID=:id")
    void updateBookInventory(@Param("id") Integer id, @Param("inventory") Integer inventory);
}
