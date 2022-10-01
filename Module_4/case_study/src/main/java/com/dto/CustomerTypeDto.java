package com.dto;

public class CustomerTypeDto {
    private Integer id;
    private String name;

    public CustomerTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerTypeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
