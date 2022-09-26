package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByCategory_Id(int id);
    Page<Blog> findAllByDescriptionContaining(String search, Pageable pageable);
    Page<Blog> findAllByDescriptionContainingAndCategory(String search, Pageable pageable, Category category);
}
