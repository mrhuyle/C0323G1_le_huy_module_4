package com.example.blog.controller;

import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "index";
    }
}
