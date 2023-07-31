package com.example.library.codes.controller;

import com.example.library.codes.service.ICodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CodesController {
    @Autowired
    private ICodesService codesService;
    @GetMapping("/showCodesList")
    public String showCodesList(Model model) {
        model.addAttribute("codesList", codesService.findAll());
        return "code";
    }
}
