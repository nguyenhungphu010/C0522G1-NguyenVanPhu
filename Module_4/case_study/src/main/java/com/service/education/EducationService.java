package com.service.education;

import com.model.employee.Education;
import com.repository.education.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService{
    @Autowired
    private IEducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(Integer id) {
        return educationRepository.findById(id).orElse(null);
    }
}
