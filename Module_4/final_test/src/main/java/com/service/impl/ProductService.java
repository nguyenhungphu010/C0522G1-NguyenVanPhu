package com.service.impl;

import com.model.Product;
import com.repository.ProductRepository;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable, String search) {
        return productRepository.findAllByNameContaining(pageable, search);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
