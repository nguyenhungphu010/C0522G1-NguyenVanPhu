package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class SavingBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String openDate;
    private String savingDate;
    @Column(name = "period_customer")
    private String period;
    private Double savingAmount;
    private Double interestRate;
    @Column(name = "promotion_customer")
    private String promotion;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customers;

    public SavingBook(Integer id, String openDate, String savingDate, String period, Double savingAmount,
                      Double interestRate, String promotion, Customer customers) {
        this.id = id;
        this.openDate = openDate;
        this.savingDate = savingDate;
        this.period = period;
        this.savingAmount = savingAmount;
        this.interestRate = interestRate;
        this.promotion = promotion;
        this.customers = customers;
    }

    public SavingBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getSavingDate() {
        return savingDate;
    }

    public void setSavingDate(String savingDate) {
        this.savingDate = savingDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(Double savingAmount) {
        this.savingAmount = savingAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
