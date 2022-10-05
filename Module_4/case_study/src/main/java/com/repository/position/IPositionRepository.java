package com.repository.position;

import com.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
