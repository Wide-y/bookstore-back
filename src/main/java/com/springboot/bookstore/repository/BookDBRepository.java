package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.BookDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookDBRepository extends MongoRepository<BookDB,Integer> {
    Optional<BookDB> findByBookId(Integer bookId);
    void deleteByBookId(Integer id);
}
