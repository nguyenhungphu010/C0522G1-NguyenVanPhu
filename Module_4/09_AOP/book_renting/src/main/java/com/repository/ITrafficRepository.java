package com.repository;

import com.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrafficRepository extends JpaRepository<Traffic,Integer> {
}
