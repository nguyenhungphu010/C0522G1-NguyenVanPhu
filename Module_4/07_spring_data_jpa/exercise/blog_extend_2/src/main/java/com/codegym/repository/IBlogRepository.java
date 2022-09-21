package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IFindBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findByDescription(String search, Pageable pageable);

    Page<Blog> findByDescriptionAndCategory(String search, Pageable pageable, Category category);

    @Query(value = "select bf.content as content, c.category as category from blog_infor as bf join category as c on bf.category_id = c.id",nativeQuery = true)
    List<IFindBlog> findBlogByContentAndCategory();
}
