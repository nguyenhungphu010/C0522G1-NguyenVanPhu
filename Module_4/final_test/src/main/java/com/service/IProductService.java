package com.service;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Page<Product> findAll(Pageable pageable, String search);

    void deleteById(Integer id);

    void save (Product product);

    Optional<Product> findById(Integer id);

}
