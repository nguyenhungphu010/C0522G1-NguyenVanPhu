package com.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_contract")
public class AttachContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private double cost;
    @Column(name = "unit")
    private String unit;
    @Column(name = "status")
    private String statusAttach;

    @OneToMany(mappedBy = "attachContractId")
    @JsonBackReference
    private Set<ContractDetail> contractDetails;

    public AttachContract(int id, String name, double cost, String unit, String statusAttach, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.statusAttach = statusAttach;
        this.contractDetails = contractDetails;
    }

    public AttachContract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatusAttach() {
        return statusAttach;
    }

    public void setStatusAttach(String statusAttach) {
        this.statusAttach = statusAttach;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
