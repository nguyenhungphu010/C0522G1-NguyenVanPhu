package com.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "status_product")
    private String statusProduct;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName ="id" )
    private ProductType productType;

    public Product(Integer id, String name, double price, String statusProduct, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public Product() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
