package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
//    List<Blog> findByTitleContainingIgnoreCase(String searchQuery);
    Page<Blog> findByTitleContainingIgnoreCase(String searchQuery, Pageable pageable);
}
