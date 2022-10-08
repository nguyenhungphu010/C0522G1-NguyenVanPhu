package com.repository.employee;

import com.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>  {


    Page<Employee> findAllByNameContaining(Pageable pageable, String search);

}
