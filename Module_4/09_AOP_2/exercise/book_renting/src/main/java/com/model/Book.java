package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private List<DetailBook> detailBooks;

    public Book(Integer id, String name, String author, Integer quantity, List<DetailBook> detailBooks) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.detailBooks = detailBooks;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<DetailBook> getDetailBooks() {
        return detailBooks;
    }

    public void setDetailBooks(List<DetailBook> detailBooks) {
        this.detailBooks = detailBooks;
    }
}
