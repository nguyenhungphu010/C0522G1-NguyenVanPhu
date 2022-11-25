package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "candidate_type")
public class CandidateType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "candidateType")
    @JsonBackReference
    private List<Candidate> candidateList;

    public CandidateType(Integer id, String type, List<Candidate> candidateList) {
        this.id = id;
        this.type = type;
        this.candidateList = candidateList;
    }

    public CandidateType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
