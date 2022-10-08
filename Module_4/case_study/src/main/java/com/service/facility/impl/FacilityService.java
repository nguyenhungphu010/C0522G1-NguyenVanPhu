package com.service.facility.impl;

import com.model.facility.Facility;
import com.repository.facility.IFacilityRepository;
import com.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAll(Pageable pageable, String search) {
        return iFacilityRepository.findAllByNameContaining(pageable,search);
    }
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable) ;
    }

    @Override
    public List<Facility> findAll() {
        return this.iFacilityRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }


}
