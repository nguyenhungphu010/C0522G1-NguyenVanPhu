package com.service.impl;

import com.model.DetailBook;
import com.repository.IBookRepository;
import com.repository.IDetailBookRepository;
import com.service.IDetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailBookService implements IDetailBookService {
    @Autowired
    private IDetailBookRepository detailBookRepository;
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<DetailBook> findAll() {
        return detailBookRepository.findAll();
    }

    @Override
    public void setStatus(Integer id) {
        detailBookRepository.setStatus(id);
    }

    @Override
    public void returnBook(Integer bookCode) throws Exception {
        List<DetailBook> detailBooks = this.detailBookRepository.findAll();
        DetailBook detailBook = this.detailBookRepository.getByBookCode(bookCode);
        if (checkBookCodeExists(bookCode, detailBooks)) {
            this.detailBookRepository.updateStatus(detailBook.getId());
            this.bookRepository.updateQuantity(detailBook.getBook().getId());
        } else {
            throw new Exception();
        }
    }

    private boolean checkBookCodeExists(Integer bookCode, List<DetailBook> detailBooks) {
        for (DetailBook detail : detailBooks) {
            if (detail.getBookCode().equals(bookCode) && detail.getStatus())
                return true;
        }
        return false;
    }
}
