package com.service.position;

import com.model.employee.Position;
import com.repository.position.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;


    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }
}
