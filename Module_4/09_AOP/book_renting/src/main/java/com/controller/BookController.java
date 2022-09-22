package com.controller;

import com.model.Book;
import com.model.DetailBook;
import com.service.IBookService;
import com.service.IDetailBookService;
import com.service.ITrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IDetailBookService detailBookService;

    @Autowired
    private ITrafficService trafficService;

    @GetMapping("")
    public String showHome(Model model) {
        List<Book> bookList = this.bookService.findAll();
        model.addAttribute("books", bookList);
        int view = this.trafficService.getById();
        model.addAttribute("view", view);
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping("/save")
    public String saveBooks(@ModelAttribute(value = "books") Book book, Model model) {
        this.bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String showDetails(@RequestParam Integer id, Model model) {
        this.bookService.borrowBook(id);
        List<DetailBook> detailBooks = detailBookService.findAll();
        model.addAttribute("detailBooks", detailBooks);
        return "/detail";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam Integer id, Model model) {
        bookService.setQuantity(id);
        detailBookService.setStatus(id);
        return "redirect:/details";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam Integer bookCode) throws Exception {
        detailBookService.returnBook(bookCode);
        return "redirect:/";
    }
}
