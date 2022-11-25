package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interview_record")
public class InterviewRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String interviewTime;
    private String interviewer;
    private Integer counts;
    private String comment;
    private Double salary;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "interview_result", referencedColumnName = "id")
    private InterviewResult interviewResult;

    @OneToMany(mappedBy = "interviewRecord")
    @JsonBackReference
    List<Candidate> candidateList;

    public InterviewRecord(Integer id, String interviewTime, String interviewer, Integer counts, String comment, Double salary, boolean isDelete, InterviewResult interviewResult, List<Candidate> candidateList) {
        this.id = id;
        this.interviewTime = interviewTime;
        this.interviewer = interviewer;
        this.counts = counts;
        this.comment = comment;
        this.salary = salary;
        this.isDelete = isDelete;
        this.interviewResult = interviewResult;
        this.candidateList = candidateList;
    }

    public InterviewRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public InterviewResult getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(InterviewResult interviewResult) {
        this.interviewResult = interviewResult;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
