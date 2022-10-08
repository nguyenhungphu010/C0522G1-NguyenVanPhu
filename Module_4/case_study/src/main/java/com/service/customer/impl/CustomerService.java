package com.service.customer.impl;

import com.model.customer.Customer;
import com.repository.customer.ICustomerRepository;
import com.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

//    @Override
//    public Page<Customer> findAll(Pageable pageable, String search) {
//        return iCustomerRepository.findAllByNameContaining(pageable, search);
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAllCustomers(pageable );
    }

    @Override
    public List<Customer> findAll() {
        return  this.iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable,  String search) {
        return iCustomerRepository.findAllByNameContaining(pageable, search);
    }

    @Override
    public void save(Customer customer) {
     iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteCustomerById(id);
    }
}
