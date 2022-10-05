package com.service.division;

import com.model.employee.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
    Division findById(Integer id);
}
