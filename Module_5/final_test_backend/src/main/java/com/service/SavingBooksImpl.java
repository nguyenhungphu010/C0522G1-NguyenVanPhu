package com.service;

import com.model.SavingBook;
import com.repository.SavingBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingBooksImpl implements SavingBookService {

    @Autowired
    private SavingBookRepository savingBookRepository;

    @Override
    public List<SavingBook> findAll() {
        return savingBookRepository.findAll();
    }

    @Override
    public void save(SavingBook savingBook) {
        savingBookRepository.save(savingBook);
    }

    @Override
    public Optional<SavingBook> findById(int id) {
        return savingBookRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        savingBookRepository.deleteById(id);
    }
}
