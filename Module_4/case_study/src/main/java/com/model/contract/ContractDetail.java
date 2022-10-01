package com.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id" )
    private AttachContract attachContractId;

    @Column(name = "quantity")
    private int quantity;

    public ContractDetail(int id, Contract contract, AttachContract attachContractId, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachContractId = attachContractId;
        this.quantity = quantity;
    }

    public ContractDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachContract getAttachContractId() {
        return attachContractId;
    }

    public void setAttachContractId(AttachContract attachContractId) {
        this.attachContractId = attachContractId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
