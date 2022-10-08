package com.service.customer;

import com.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable, String search);

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void remove(int id);
}
