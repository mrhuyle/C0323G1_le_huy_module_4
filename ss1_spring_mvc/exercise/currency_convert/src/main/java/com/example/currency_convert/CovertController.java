package com.example.currency_convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CovertController {
    @GetMapping
    public String show() {
        return "show";
    }

    @PostMapping
    public String convert(@RequestParam double amount, @RequestParam String currency, Model model) {
        double result;
        if (currency.equals("usd")) {
            result = amount * 22000;
            model.addAttribute("result", String.valueOf(result) + " VND");
        } else {
            result = amount / 22000;
            model.addAttribute("result", String.valueOf(result) + " USD");
        }
        return "show";
    }
}
