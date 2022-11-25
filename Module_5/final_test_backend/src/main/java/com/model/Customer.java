package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @Column(name = "customer_name")
    private String name;


    @OneToMany(mappedBy = "customers")
    private List<SavingBook> bookSet;

    public Customer(Integer id, String name, List<SavingBook> bookSet) {
        this.id = id;
        this.name = name;
        this.bookSet = bookSet;
    }

    public Customer() {

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

    public List<SavingBook> getBookSet() {
        return bookSet;
    }

    public void setBookSet(List<SavingBook> bookSet) {
        this.bookSet = bookSet;
    }
}
