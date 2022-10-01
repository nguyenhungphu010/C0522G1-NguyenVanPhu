package com.service.contract.impl;

import com.model.contract.AttachContract;
import com.repository.contract.IAttachContractRepository;
import com.service.contract.IAttachContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachContractService implements IAttachContractService {
    @Autowired
    private IAttachContractRepository attachContractRepository;
    @Override
    public List<AttachContract> findAllAttachContract(int id) {
        return attachContractRepository.findAttachContract(id);
    }

    @Override
    public AttachContract findById(int id) {
        return attachContractRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachContract> findAll() {
        return attachContractRepository.findAll();
    }
}
