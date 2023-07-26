package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private ICategoryService categoryService;

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

    @GetMapping("/show-create-form")
    public String showCreateForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("blog", new Blog());
        model.addAttribute("edit", false);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "Created Successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        blogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/show-edit-form/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("edit", true);
        return "create";
    }

    @PostMapping("/edit/{categoryId}")
    public String edit(@ModelAttribute Blog blog, @PathVariable("categoryId") int categoryId ,RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        blogService.edit(blog);
        redirectAttributes.addFlashAttribute("msg", "Edited Successfully");
        return "redirect:/";
    }
}
