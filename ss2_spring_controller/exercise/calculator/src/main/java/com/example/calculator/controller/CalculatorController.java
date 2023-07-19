package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    public ICalculatorService calculatorService;
    @GetMapping("/")
    public String show() {
        return "show";
    }
    @PostMapping(value = "/calculator")
    public String calculate(@RequestParam("expression") String expression, Model model) {
        String resultStr = calculatorService.calculate(expression);
        model.addAttribute("resultStr", resultStr);
        return "show";
    }
}
