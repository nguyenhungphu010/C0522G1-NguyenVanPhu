package com.service;

import com.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IProductService {

//    Page<Product> findAll();
    List<Product> findAll();
    Optional<Product> findById(int id);
    void save(Product product);
}
