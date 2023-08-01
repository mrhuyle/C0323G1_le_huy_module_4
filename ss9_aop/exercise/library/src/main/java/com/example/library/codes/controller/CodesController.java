package com.example.library.codes.controller;

import com.example.library.books.service.IBooksService;
import com.example.library.codes.model.Codes;
import com.example.library.codes.service.ICodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodesController {
    @Autowired
    private ICodesService codesService;

    @Autowired
    private IBooksService booksService;

    @GetMapping("/showCodesList")
    public String showCodesList(Model model) {
        model.addAttribute("codesList", codesService.findAll());
        return "code";
    }

    @GetMapping("/showReturnForm")
    public String showReturnForm(@ModelAttribute Codes code, Model model) {
        model.addAttribute("code", new Codes());
        return "return";
    }

    @GetMapping("/showCode")
    public String showCode(@ModelAttribute Codes code, Model model, @RequestParam(value = "code", required = false) String inputCode) {
        Codes foundCode = codesService.findByCode(inputCode);
        if (foundCode != null && !foundCode.isFlag()) {
            model.addAttribute("code", foundCode);
        } else {
            model.addAttribute("code", new Codes());
        }
        return "return";
    }

    @GetMapping("/returnBook")
    public String returnBook(@RequestParam("idReturn") Long idReturn, Model model) {
        codesService.returnBook(idReturn);
        booksService.setBookReturn(idReturn);
        model.addAttribute("msg","Return successfully");
        model.addAttribute("bookslist", booksService.findAll());
        return "home";
    }
}
