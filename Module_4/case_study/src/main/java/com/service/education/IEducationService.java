package com.service.education;

import com.model.employee.Education;

import java.util.List;

public interface IEducationService {
    List<Education> findAll();
    Education findById(Integer id);
}
