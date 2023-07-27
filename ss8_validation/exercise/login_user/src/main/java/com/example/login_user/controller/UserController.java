package com.example.login_user.controller;

import com.example.login_user.dto.UserDto;
import com.example.login_user.model.User;
import com.example.login_user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("msg", "msg");
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        BeanUtils.copyProperties(userDto, user);
        userService.create(user);
        redirectAttributes.addFlashAttribute("msg", "created sucessfully");
        return "redirect:/";
    }

}
