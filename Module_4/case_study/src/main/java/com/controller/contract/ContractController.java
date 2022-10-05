package com.controller.contract;

import com.service.contract.IAttachContractService;
import com.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachContractService attachContractService;


    @GetMapping("/list")
    public String showContract(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("contractList", contractService.findAllAndTotalMoney(pageable));
        return "/contract/contractList";
    }
}
