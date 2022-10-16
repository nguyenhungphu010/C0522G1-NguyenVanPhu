package com.repository;

import com.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}
