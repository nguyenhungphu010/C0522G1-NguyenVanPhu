package com.repository.division;

import com.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
