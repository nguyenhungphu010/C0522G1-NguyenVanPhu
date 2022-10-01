package com.service.contract;

import com.model.contract.Contract;
import com.sun.xml.bind.v2.schemagen.episode.Package;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {

    Page<Contract>findAll(Pageable pageable);
    Page<Contract> findAll(Pageable pageable, String search);
    void deleteById(int id);
    void save(Contract contract);
    Optional<Contract> findById(int id);
    Page<Contract> findAllAndTotalMoney(Pageable pageable);
}
