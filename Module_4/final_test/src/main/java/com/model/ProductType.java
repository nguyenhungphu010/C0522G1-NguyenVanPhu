package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productType")
    private Set<Product> productSet;

    public ProductType(Integer id, String name, Set<Product> productSet) {
        this.id = id;
        this.name = name;
        this.productSet = productSet;
    }

    public ProductType() {
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
