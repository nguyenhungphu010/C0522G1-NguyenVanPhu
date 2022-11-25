package com.controller;

import com.model.Candidate;
import com.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/candidate")
public class InterviewRestController {

    @Autowired
    private ICandidateService candidateService;

    @GetMapping("/list")
    public ResponseEntity<Page<Candidate>> findAllCandidate(@PageableDefault(size = 5) Pageable pageable,
                                                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                                           @RequestParam(value = "typeSearch", defaultValue = "") Integer typeSearch) {
        Page<Candidate> candidatePage = candidateService.findAllCandidate(pageable, nameSearch, typeSearch);
        if (candidatePage.hasContent()) {
            return new ResponseEntity<>(candidatePage, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        this.candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
