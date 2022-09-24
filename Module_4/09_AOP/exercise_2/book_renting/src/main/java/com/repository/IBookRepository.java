package com.repository;

import com.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import javax.transaction.Transactional;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE book Set quantity = quantity -1 WHERE (id=:id);" , nativeQuery = true)
    void setQuantity(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE book Set quantity = quantity + 1 WHERE (id=:id);" , nativeQuery = true)
    void updateQuantity(@Param("id") Integer id);
}
