package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void edit(Blog blog) {
        Blog currentBlog = blogRepository.findById(blog.getId()).get();
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setContent(blog.getContent());
        currentBlog.setDate(blog.getDate());
        currentBlog.setImg(blog.getImg());
        currentBlog.setTitle(blog.getTitle());
        blogRepository.save(currentBlog);
    }
}
