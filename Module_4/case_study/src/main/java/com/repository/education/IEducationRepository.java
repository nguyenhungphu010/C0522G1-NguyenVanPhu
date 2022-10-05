package com.repository.education;

import com.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education, Integer> {
}
