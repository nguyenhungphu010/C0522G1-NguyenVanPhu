package com.service.impl;

import com.model.Book;
import com.model.DetailBook;
import com.repository.IBookRepository;
import com.repository.IDetailBookRepository;
import com.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IDetailBookRepository detailBookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void borrowBook(Integer id) {
        Book book = this.bookRepository.getById(id);
        if (this.detailBookRepository.existsById(id)) {
            for (int i = 0; i < book.getQuantity(); i++) {
                List<DetailBook> detailBooks = detailBookRepository.findAll();
                DetailBook detailBook = new DetailBook();
                detailBook.setBookCode(getRandomNumber(detailBooks));
                detailBook.setStatus(false);
                detailBook.setBook(book);
                this.detailBookRepository.save(detailBook);
            }
        }
    }

    private Integer getRandomNumber(List<DetailBook> detailBooks) {
        int randomNumber = 10000;
        while (checkExists(detailBooks, randomNumber)) {
            randomNumber = (int) (Math.random() * 89999);
        }
        return  randomNumber;
    }

    @Override
    public void setQuantity(Integer id) {
        bookRepository.setQuantity(detailBookRepository.getById(id).getBook().getId());
    }
    private boolean checkExists(List<DetailBook> detailBooks, int randomNumber) {
        for (DetailBook detailBook : detailBooks) {
            if (detailBook.getBookCode() == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
