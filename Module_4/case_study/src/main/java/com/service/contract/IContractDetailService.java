package com.service.contract;

import com.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAllByContract_id(Integer id);
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
