package com.service.impl;

import com.model.User;
import com.repository.IFormRepository;
import com.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService {

    @Autowired
    private IFormRepository formRepository;

    @Override
    public void save(User user) {
        formRepository.save(user);
    }
}
