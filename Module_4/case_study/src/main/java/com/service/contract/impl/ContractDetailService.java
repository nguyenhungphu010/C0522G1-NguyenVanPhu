package com.service.contract.impl;

import com.model.contract.ContractDetail;
import com.repository.contract.IContractDetailRepository;
import com.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAllByContract_id(Integer id) {
        return contractDetailRepository.findAllByContract_id(id);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }
}
