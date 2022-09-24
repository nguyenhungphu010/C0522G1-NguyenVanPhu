package com.repository;

import com.model.DetailBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IDetailBookRepository extends JpaRepository<DetailBook, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE detail_book set status =1 where (id= :detailID); ", nativeQuery = true)
    void setStatus(@Param("detailID") int detailID);

    @Query(value = "select * from detail_book where (book_code = :bookCode);", nativeQuery = true)
    DetailBook getByBookCode(@Param("bookCode") Integer bookCode);

    @Modifying
    @Transactional
    @Query(value = "update detail_book set status=0 where (id = :id);", nativeQuery = true)
    void updateStatus(@Param("id") Integer id);
}
