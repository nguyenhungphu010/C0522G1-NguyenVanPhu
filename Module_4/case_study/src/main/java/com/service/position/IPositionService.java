package com.service.position;

import com.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Position findById(Integer id);
}
