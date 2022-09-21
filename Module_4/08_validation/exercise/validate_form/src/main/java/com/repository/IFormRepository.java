package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository<User,Integer> {
}
