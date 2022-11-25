package com.repository;

import com.model.InterviewRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInterviewRepository extends JpaRepository<InterviewRecord,Integer> {


}
