package com.service.contract.impl;

import com.model.contract.AttachContract;
import com.model.contract.Contract;
import com.model.contract.ContractDetail;
import com.repository.contract.IAttachContractRepository;
import com.repository.contract.IContractDetailRepository;
import com.repository.contract.IContractRepository;
import com.service.contract.IAttachContractService;
import com.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachContractService attachContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable, String search) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        Contract contract = contractRepository.findById(id).orElse(null);
        assert contract != null;
        contract.setStatus(true);
        contractRepository.save(contract);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAllAndTotalMoney(Pageable pageable) {
        Page<Contract> contractPage = contractRepository.findAll(pageable);

        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<AttachContract> attachContractList = attachContractRepository.findAll();

        for (Contract c: contractPage) {
            double totalDetail = 0 ;
            double costFacility = 0 ;
            for (ContractDetail cd : contractDetailList){
                if (cd.getContract().getId() == c.getId()){
                    for (AttachContract ac : attachContractList){
                        if (ac.getId() == cd.getAttachContractId().getId()){
                            costFacility += cd.getQuantity()*ac.getCost();
                        }
                    }
                }
            }
            totalDetail = costFacility + c.getFacility().getCost();
            c.setTotalMoney(totalDetail);
        }
        return contractRepository.findAll(pageable);
    }
}
