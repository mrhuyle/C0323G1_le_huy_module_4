package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("api/blogs")
    public ResponseEntity<List<Blog>> getListBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        System.out.println(blogs);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
