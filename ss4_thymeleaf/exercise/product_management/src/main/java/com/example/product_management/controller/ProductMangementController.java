package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductMangementController {
    @Autowired
    private IProductManagementService productManagementService;

    @GetMapping("/")
    public ModelAndView displayAllProducts() {
        List<Product> productList = productManagementService.displayAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/show-create-form")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create_form");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, Model model) {
        productManagementService.create(product);
        List<Product> productList = productManagementService.displayAll();
        model.addAttribute("productList", productList);
        return "home";

    }
}
