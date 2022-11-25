package com.controller;

import com.model.SavingBook;
import com.service.SavingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/final_test")
public class FinalTestController {

    @Autowired
    private SavingBookService savingBookService;

    @GetMapping("/{id}")
    public ResponseEntity<SavingBook> getSavingBook(@PathVariable int id) {
        Optional<SavingBook> book = savingBookService.findById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books")
    public ResponseEntity<List<SavingBook>> showBookList() {
        List<SavingBook> savingBookList = this.savingBookService.findAll();
        if (savingBookList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(savingBookList, HttpStatus.OK);
    }

    @PutMapping("/saveUpdate/{id}")
    public ResponseEntity<SavingBook> saveBook(@PathVariable int id) {
        Optional<SavingBook> book = savingBookService.findById(id);
        if (book.isPresent()) {
            this.savingBookService.save(book.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SavingBook> deleteBook(@PathVariable int id){
        Optional<SavingBook> book = savingBookService.findById(id);
        if (book.isPresent()) {
            this.savingBookService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
