package com.service;

import com.model.SavingBook;

import java.util.List;
import java.util.Optional;

public interface SavingBookService {
    List<SavingBook>findAll();

    void save( SavingBook savingBook);

    Optional<SavingBook> findById(int id);

    void remove(int id);
}
