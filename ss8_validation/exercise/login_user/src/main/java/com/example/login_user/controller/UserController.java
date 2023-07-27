package com.example.login_user.controller;

import com.example.login_user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("msg", "msg");
        return "register";
    }
}
