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

    public void addProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            Integer currentValue = productDtoMap.get(productDto);
            productDtoMap.put(productDto, currentValue + 1); // update
        } else
            productDtoMap.put(productDto, 1); // add
    }

    public void decreaseProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            Integer currentValue = productDtoMap.get(productDto);
            if (currentValue > 1) {
                productDtoMap.replace(productDto, currentValue - 1);
            } else {
                productDtoMap.remove(productDto);
            }
        }
    }

    public void remove(ProductDto productDto) {
        productDtoMap.remove(productDto);
    }

    public Double totalPayment() {
        double total = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()){
            total += entry.getKey().getPrice() * (double)entry.getValue();
        }
           return total;
    }
}
