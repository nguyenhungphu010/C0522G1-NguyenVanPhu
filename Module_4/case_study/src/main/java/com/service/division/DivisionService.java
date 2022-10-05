package com.service.division;

import com.model.employee.Division;
import com.repository.division.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService{

    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(Integer id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
