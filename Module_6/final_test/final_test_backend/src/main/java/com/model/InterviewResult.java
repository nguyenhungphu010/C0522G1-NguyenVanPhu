package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interview_result")
public class InterviewResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String result;

    @OneToMany(mappedBy = "interviewResult")
    @JsonBackReference
    List<InterviewRecord> interviewRecords;

    public InterviewResult(Integer id, String result, List<InterviewRecord> interviewRecords) {
        this.id = id;
        this.result = result;
        this.interviewRecords = interviewRecords;
    }

    public InterviewResult() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<InterviewRecord> getInterviewRecords() {
        return interviewRecords;
    }

    public void setInterviewRecords(List<InterviewRecord> interviewRecords) {
        this.interviewRecords = interviewRecords;
    }
}
