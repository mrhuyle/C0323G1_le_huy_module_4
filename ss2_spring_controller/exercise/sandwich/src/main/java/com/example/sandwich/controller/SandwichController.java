package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping
    public String show() {
        return "show";
    }
    @PostMapping("/condiment")
    public String list(@RequestParam(value = "condiments", required = false) String[] condiments, Model model) {
        String msg = null;
        if (condiments.length == 0) {
            msg = "You had chosen nothing";
        }
        model.addAttribute("condiments", condiments);
        model.addAttribute("msg", msg);
        return "list";
    }
}
