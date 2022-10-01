package com.controller.contract;

import com.model.contract.AttachContract;
import com.model.contract.ContractDetail;
import com.service.contract.IAttachContractService;
import com.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restContracts")
public class ContractRestController {

    @Autowired
    private IAttachContractService attachContractService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<AttachContract>> showModalContractDetail(@PathVariable Integer id){

        List<AttachContract> allAttachContract = attachContractService.findAllAttachContract(id);

        if (allAttachContract.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(allAttachContract, HttpStatus.OK);
    }
}
