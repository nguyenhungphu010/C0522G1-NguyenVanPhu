package com.repository;

import com.model.SavingBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingBookRepository extends JpaRepository<SavingBook, Integer> {

}
