package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showHomePage(@RequestParam(required = false) String search, @RequestParam(name="page", defaultValue = "0") int page, Model model) {
        int pageSize = 3;
        PageRequest pageRequest = PageRequest.of(page,pageSize, Sort.by("date").ascending());
        if (search != null && !search.trim().isEmpty()) {
            Page<Blog> blogPage = blogService.searchByTitlePaged(search, pageRequest);
            model.addAttribute("blogList", blogPage.getContent());
            model.addAttribute("author", authorService.findById(1));
            model.addAttribute("currentPage",page);
            model.addAttribute("totalPages",blogPage.getTotalPages());
        } else {
            Page<Blog> blogPage = blogService.findAllPaged(pageRequest);
            model.addAttribute("blogList", blogPage.getContent());
            model.addAttribute("author", authorService.findById(1));
            model.addAttribute("currentPage",page);
            model.addAttribute("totalPages",blogPage.getTotalPages());
        }
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
