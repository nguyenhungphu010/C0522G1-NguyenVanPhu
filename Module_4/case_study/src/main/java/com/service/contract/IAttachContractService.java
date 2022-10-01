package com.service.contract;

import com.model.contract.AttachContract;

import java.util.List;

public interface IAttachContractService {
    List<AttachContract> findAllAttachContract(int id);
    AttachContract findById(int id);
    List<AttachContract> findAll();
 }
