package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void create(Blog blog);
    void deleteById(int id);
    void edit(Blog blog);
//    List<Blog> searchByTitle(String searchQuery);
    Page<Blog> searchByTitlePaged(String searchQuery, Pageable pageable);
    Page<Blog> findAllPaged(Pageable pageable);
}
