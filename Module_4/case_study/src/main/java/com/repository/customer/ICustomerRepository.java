package com.repository.customer;

import com.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//   Page<Customer> findAllByNameContaining(Pageable pageable, String search);

   @Query(value = " select * from customer where is_deleted = 0", nativeQuery = true)
    Page<Customer> findAllCustomers(Pageable pageable);

    @Query(value = " select * from customer where name like concat('%',:searchVal,'%') and is_deleted = 0", nativeQuery = true,
    countQuery = "select count(*) from (select * from customer where name like concat('%',:searchVal,'%') and is_deleted = 0) customer")
    Page<Customer> findAllByNameContaining(Pageable pageable,@Param("searchVal") String search);

   @Modifying
   @Transactional
   @Query(value = " update customer set is_deleted = 1 where id = :id ", nativeQuery = true)
    void deleteCustomerById(@Param("id") int id);


   // e viết riêng cho nghe
    Page<Customer> findAllByDeletedFalse(Pageable pageable);
}
