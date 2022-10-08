package com.controller.contract;

import com.model.contract.Contract;
import com.model.contract.ContractDetail;
import com.service.contract.IAttachContractService;
import com.service.contract.IContractService;
import com.service.contract.impl.AttachContractService;
import com.service.contract.impl.ContractDetailService;
import com.service.contract.impl.ContractService;
import com.service.customer.ICustomerService;
import com.service.customer.impl.CustomerService;
import com.service.employee.IEmployeeService;
import com.service.employee.impl.EmployeeService;
import com.service.facility.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private AttachContractService attachContractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private ContractDetailService contractDetailService;


    @GetMapping("/list")
    public String showContract(@PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("contractList", contractService.findAllAndTotalMoney(pageable));
        model.addAttribute("attachContractList", this.attachContractService.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        return "/contract/contractList";
    }

    @GetMapping("/create")
    public String showCreateContract( Model model){
        model.addAttribute("contractObj",new Contract());
        model.addAttribute("employeeList", this.employeeService.findAll());
        model.addAttribute("customerList", this.customerService.findAll());
        model.addAttribute("facilityList", this.facilityService.findAll());
        return "contract/contractCreate";
    }

    @PostMapping("/save")
    public String saveContract(@ModelAttribute Contract contractObj){
        this.contractService.save(contractObj);
        return "redirect:/contracts/list";
    }

    @PostMapping("/saveDetailContract")
    public String saveContractDetail(@ModelAttribute ContractDetail contractDetail){
        this.contractDetailService.save(contractDetail);
        return "redirect:/contracts/list";
    }
}
