package com.controller;

import com.model.Blog;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;
    @GetMapping(value = {"/list"})
    public ResponseEntity<Page<Blog>> blogList(Pageable pageable, @RequestParam(defaultValue = "", required = false) String search) {
        Page<Blog> blogPage = this.blogService.findAll(pageable,search);
        if (!blogPage.hasContent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Blog> save(@RequestBody Blog phone) {
        return new ResponseEntity<>(this.blogService.save(phone), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePhone(@RequestParam int id) {
        this.blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
