package com.service.impl;

import com.model.Candidate;
import com.repository.ICandidateRepository;
import com.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CandidateServiceImpl implements ICandidateService {

    @Autowired
    private ICandidateRepository candidateRepository;
    @Override
    public void deleteCandidate(Integer id) {
        candidateRepository.deleteCandidateById(id);
    }

    @Override
    public void saveCandidate(Candidate candidate) {

    }

    @Override
    public Optional<Candidate> findCandidateById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Candidate> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updateEmployee(Candidate candidate) {

    }

    @Override
    public Page<Candidate> findAllCandidate(Pageable pageable, String searchName, Integer typeSearch) {
        return candidateRepository.findEmployeeByAll(pageable,searchName,typeSearch);
    }
}
