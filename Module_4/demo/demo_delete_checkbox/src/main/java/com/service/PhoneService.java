package com.service;

import com.model.Phone;
import com.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements  IPhoneService{

    @Autowired
    private IPhoneRepository phoneRepository;
    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        phoneRepository.deleteById(id);
    }

}
