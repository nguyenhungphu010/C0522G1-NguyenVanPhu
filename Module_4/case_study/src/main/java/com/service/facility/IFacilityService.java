package com.service.facility;

import com.model.facility.Facility;
import com.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {

    Page<Facility> findAll(Pageable pageable, String search);
    Page<Facility> findAll(Pageable pageable);
    List<Facility> findAll();
    void deleteById(int id);
    void save(Facility facility);
    Optional<Facility> findById(int id);
}
