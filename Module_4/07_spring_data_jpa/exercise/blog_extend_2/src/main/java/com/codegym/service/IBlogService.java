package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
Page<Blog> findBlogPage(Pageable pageable, String search, Category category);
Optional<Blog> findById(int id);
void save(Blog blog);
void update(Blog blog);
void delete(int id);
}
