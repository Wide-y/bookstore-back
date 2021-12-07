package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.UserMysql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserMysqlRepository extends JpaRepository<UserMysql, Integer> {
    @Query("select u from UserMysql u where u.userType <> 2")
    List<UserMysql> getAllUsers();

    @Transactional
    @Modifying
    @Query("update UserMysql u set u.userType=:type where u.userId=:id")
    Integer updateUserType(@Param("id") Integer id, @Param("type") Integer type);
}
