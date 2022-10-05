package com.controller.employee;

import com.dto.EmployeeDto;
import com.model.employee.Employee;
import com.model.employee.Position;
import com.service.division.IDivisionService;
import com.service.education.IEducationService;
import com.service.employee.IEmployeeService;
import com.service.position.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/employees")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Optional<Employee> employee = this.employeeService.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/showUpdate")
    public ResponseEntity<EmployeeDto> showUpdate(@RequestParam Integer id) {
        Optional<Employee> employee = this.employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        if (employee.isPresent()){
            BeanUtils.copyProperties(employee.get(), employeeDto);
            return  new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/save")
    public ResponseEntity<List<FieldError>> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        System.out.println(employeeDto.getPhoneNumber());
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setName(employeeDto.getName());
//        employee.setDateOfBirth(employeeDto.getDateOfBirth());
//        employee.setIdCard(employeeDto.getIdCard());
//        employee.setSalary(employeeDto.getSalary());
//        employee.setPhoneNumber(employeeDto.getPhoneNumber());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setAddress(employeeDto.getAddress());
//        employee.setPosition(iPositionService.findById(employeeDto.getId()));
//        employee.setDivision(divisionService.findById(employeeDto.getId()));
//        employee.setEducation(educationService.findById(employeeDto.getId()));
        BeanUtils.copyProperties(employeeDto, employee);
        try {
            this.employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/saveUpdate")
    public ResponseEntity<List<FieldError>> saveUpdateEmployee(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setName(employeeDto.getName());
//        employee.setDateOfBirth(employeeDto.getDateOfBirth());
//        employee.setIdCard(employeeDto.getIdCard());
//        employee.setSalary(employeeDto.getSalary());
//        employee.setPhoneNumber(employeeDto.getPhoneNumber());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setAddress(employeeDto.getAddress());
//        employee.setPosition(iPositionService.findById(employeeDto.getId()));
//        employee.setDivision(divisionService.findById(employeeDto.getId()));
//        employee.setEducation(educationService.findById(employeeDto.getId()));
        BeanUtils.copyProperties(employeeDto, employee);
        try {
            this.employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
