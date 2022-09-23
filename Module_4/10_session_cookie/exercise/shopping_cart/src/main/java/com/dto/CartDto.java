package com.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    Map<ProductDto, Integer> productDtoMap = new HashMap<>();

    public CartDto(Map<ProductDto, Integer> productDtoMap) {
        this.productDtoMap = productDtoMap;
    }

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductDtoMap() {
        return productDtoMap;
    }

    public void setProductDtoMap(Map<ProductDto, Integer> productDtoMap) {
        this.productDtoMap = productDtoMap;
    }

}
