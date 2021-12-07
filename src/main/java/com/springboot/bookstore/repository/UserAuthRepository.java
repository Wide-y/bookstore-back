package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAuthRepository extends JpaRepository<UserAuth,Integer> {
    @Query("select t from UserAuth t where t.username = ?1")
    UserAuth getAuth(String username);
}
