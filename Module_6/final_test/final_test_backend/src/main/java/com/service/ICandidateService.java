package com.service;

import com.model.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICandidateService {
    void deleteCandidate(Integer id);

    void saveCandidate(Candidate candidate );

    Optional<Candidate> findCandidateById(Integer id);

    Optional<Candidate> findById(Integer id);

    void updateEmployee(Candidate candidate);

    Page<Candidate> findAllCandidate(Pageable pageable, String searchName, Integer typeSearch);
}
