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
    public void addProduct( ProductDto productDto){
        if (productDtoMap.containsKey(productDto)){
            Integer currentValue = productDtoMap.get(productDto);
            productDtoMap.put(productDto, currentValue +1); // update
        }else
            productDtoMap.put(productDto, 1); // add
    }


}
