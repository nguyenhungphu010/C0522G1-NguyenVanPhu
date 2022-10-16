package com.service.impl;

import com.model.ProductType;
import com.repository.ProductRepository;
import com.repository.ProductTypeRepository;
import com.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
