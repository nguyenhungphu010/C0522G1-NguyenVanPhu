package com.repository;

import com.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {



    @Query(value = "select * from candidate where name like %:nameSearch% and  candidate_type like %:typeSearch% and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from candidate where name like  %:nameSearch% and candidate_type like %:typeSearch% and is_delete = 0 ) candidate")
    Page<Candidate> findEmployeeByAll(Pageable pageable,
                                     @Param("nameSearch") String nameSearch,
                                     @Param("typeSearch") Integer typeSearch);

    @Modifying
    @Transactional
    @Query(value = " update candidate set is_delete = 1 where id = :id ", nativeQuery = true)
    void deleteCandidateById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `user` SET `user`.is_delete = 1 WHERE username IN (SELECT temp.username FROM (SELECT `user`.username FROM `user` JOIN employee ON employee.username = `user`.username WHERE employee.id = :id) temp); ", nativeQuery = true)
    void updateUserById(int id);
}
