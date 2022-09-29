package com.service;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService  {
    Iterable<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAll(Pageable pageable, String search);
    Optional<Blog> findById(Integer id);
    Blog save(Blog blog);
    void remove(Integer id);
}
