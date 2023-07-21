package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductMangementController {
    @Autowired
    private IProductManagementService productManagementService;

    @GetMapping("/")
    public ModelAndView show() {
        List<Product> productList = productManagementService.displayAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }
}
