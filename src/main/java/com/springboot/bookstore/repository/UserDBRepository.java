package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.UserDB;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDBRepository extends MongoRepository<UserDB,Integer> {
    Optional<UserDB> findByUserId(Integer id);
}
