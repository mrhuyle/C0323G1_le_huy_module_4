package com.example.email_setting.controller;

import com.example.email_setting.model.EmailSetting;
import com.example.email_setting.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSettingController {
    @Autowired
    public IEmailSettingService emailSettingService;

    @ModelAttribute("languageOptions")
    public String[] getLanguageOptions() {
        String[] languageOptions = {"English", "Vietnamese", "Japanese", "Chinese"};
        return languageOptions;
    }

    @ModelAttribute("sizeOptions")
    public int[] getSizeOptions() {
        int[] sizeOptions = {5, 10, 15, 25, 50, 100};
        return sizeOptions;
    }

    @GetMapping("/")
    public String show(Model model) {
        EmailSetting defaultEmailSetting = emailSettingService.getDefault();
        model.addAttribute("emailSetting", defaultEmailSetting);
        return "home";
    }

    @GetMapping("/form")
    public String submit(@ModelAttribute("emailSetting") EmailSetting emailSetting) {
        return "form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("emailSetting") EmailSetting emailSetting) {
        emailSettingService.update(emailSetting);
        return "home";
    }
}
