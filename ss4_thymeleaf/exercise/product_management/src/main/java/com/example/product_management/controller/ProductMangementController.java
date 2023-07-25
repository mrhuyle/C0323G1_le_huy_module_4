package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productManagementService.create(product);
        redirectAttributes.addFlashAttribute("message", "Successfully created");
        return "redirect:/";
    }

    @GetMapping("/show-detail-form/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Product product = productManagementService.getProductById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/show-update-form/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = productManagementService.getProductById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productManagementService.update(product);
        redirectAttributes.addFlashAttribute("message", "Successfully updated");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productManagementService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Successfully deleted");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> productList = productManagementService.searchByName('%' + name + '%');
        model.addAttribute("productList", productList);
        model.addAttribute("message", "Result with search string: " + name);
        return "home";
    }
}
