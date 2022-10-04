package com.service.employee;

import com.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void remove(Integer id);

    Optional<Employee> findById(Integer id);

    void save(Employee employee);

}
