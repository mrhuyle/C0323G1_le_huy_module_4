package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        model.addAttribute("author", authorService.findById(1));
        return "blog";
    }

    @GetMapping("/detail/{id}")
    public String toDetail(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            model.addAttribute(blog);
            return "detail";
        }
        return "redirect:/";
    }
}
