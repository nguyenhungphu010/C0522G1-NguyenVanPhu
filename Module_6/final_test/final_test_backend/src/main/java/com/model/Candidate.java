package com.model;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dayOfBirth;
    private String phoneNumber;
    private Integer experiencedYear;
    private String specialist;
    private String graduatedYear;
    private String graduatedResult;
    private String graduatedSchool;
    private String major;
    private Integer currentSemester;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "candidate_type", referencedColumnName = "id")
    private CandidateType candidateType;

    @ManyToOne
    @JoinColumn(name = "interview_record", referencedColumnName = "id")
    private InterviewRecord interviewRecord;

    public Candidate(Integer id, String name, String dayOfBirth, String phoneNumber, Integer experiencedYear,
                     String specialist, String graduatedYear, String graduatedResult, String graduatedSchool, String major, Integer currentSemester, boolean isDelete, CandidateType candidateType, InterviewRecord interviewRecord) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.phoneNumber = phoneNumber;
        this.experiencedYear = experiencedYear;
        this.specialist = specialist;
        this.graduatedYear = graduatedYear;
        this.graduatedResult = graduatedResult;
        this.graduatedSchool = graduatedSchool;
        this.major = major;
        this.currentSemester = currentSemester;
        this.isDelete = isDelete;
        this.candidateType = candidateType;
        this.interviewRecord = interviewRecord;
    }

    public Candidate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getExperiencedYear() {
        return experiencedYear;
    }

    public void setExperiencedYear(Integer experiencedYear) {
        this.experiencedYear = experiencedYear;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getGraduatedYear() {
        return graduatedYear;
    }

    public void setGraduatedYear(String graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public String getGraduatedResult() {
        return graduatedResult;
    }

    public void setGraduatedResult(String graduatedResult) {
        this.graduatedResult = graduatedResult;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Integer currentSemester) {
        this.currentSemester = currentSemester;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public CandidateType getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType) {
        this.candidateType = candidateType;
    }

    public InterviewRecord getInterviewRecord() {
        return interviewRecord;
    }

    public void setInterviewRecord(InterviewRecord interviewRecord) {
        this.interviewRecord = interviewRecord;
    }
}
