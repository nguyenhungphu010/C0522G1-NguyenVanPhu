package com.controller.customer;

import com.dto.CustomerDto;
import com.dto.CustomerTypeDto;
import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.service.customer.ICustomerService;
import com.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String showCustomerList(@PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String searchParam, Model model) {
        Page<Customer> page = iCustomerService.findAll(pageable, searchParam);
        model.addAttribute("customerList", page);
        model.addAttribute("searchParam", searchParam);
        return "customer/customerList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/customerCreate";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute(value = "customerDto") @Valid CustomerDto customerDto,
    BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer/customerCreate";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerTypeDto().getId());
        customer.setCustomerType(customerType);
        iCustomerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/showEdit")
    public String showEditForm(@RequestParam int id, Model model) {

        Customer customer = iCustomerService.findById(id).orElse(null);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setId(customer.getCustomerType().getId());
        customerDto.setCustomerTypeDto(customerTypeDto);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/customerEdit";
    }

    @PostMapping("/saveEdit")
    public String saveEditCustomer(@ModelAttribute(value = "customerDto")@Valid CustomerDto customerDto,
    BindingResult bindingResult,Model model) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerType",customerTypeService.findAll());
            return "customer/customerEdit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerTypeDto().getId());
        customer.setCustomerType(customerType);

        iCustomerService.save(customer);
        return "redirect:/customers/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam int IdCustomer) {
        iCustomerService.remove(IdCustomer);
        return "redirect:/customers/list";
    }
}
