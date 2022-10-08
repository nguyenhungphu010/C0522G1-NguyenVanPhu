package com.controller.employee;

import com.service.division.DivisionService;
import com.service.education.EducationService;
import com.service.employee.IEmployeeService;
import com.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationService educationService;

    @Autowired
    private DivisionService divisionService;

    @GetMapping("/list")
    public String showEmployeeList(@PageableDefault(size=5) Pageable pageable,@RequestParam(defaultValue = "") String searchParam,  Model model){
        model.addAttribute("employeeList",employeeService.findAll(pageable,searchParam));
        model.addAttribute("positionList", this.positionService.findAll());
        model.addAttribute("divisionList", this.divisionService.findAll());
        model.addAttribute("educationList", this.educationService.findAll());
        return "employee/employeeList";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer IdEmployee){
         this.employeeService.remove(IdEmployee);
        return "redirect:/employees/list";
    }
}
