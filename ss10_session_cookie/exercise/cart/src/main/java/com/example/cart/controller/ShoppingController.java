package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ShoppingController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("/plusProduct/{id}")
    public String plusProduct(@PathVariable("id") Long id, @SessionAttribute("cart") Cart cart, Model model) {
        Product product = productService.findById(id).get();
        cart.addProduct(product);
        model.addAttribute("cart",cart);
        return "redirect:/shopping-cart";
    }

}
