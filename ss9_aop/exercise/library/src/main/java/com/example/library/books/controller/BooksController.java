package com.example.library.books.controller;

import com.example.library.books.model.Books;
import com.example.library.books.service.IBooksService;
import com.example.library.codes.model.Codes;
import com.example.library.codes.service.ICodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class BooksController {
    @Autowired
    private IBooksService booksService;
    @Autowired
    private ICodesService codesService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("bookslist", booksService.findAll());
        return "home";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam("borrowId") Long borrowId, Model model) {
        Books book = booksService.findById(borrowId);
        if (book != null && book.getAvailableCopies() > 0) {
            booksService.setCopies(book);
            codesService.borrow(book);
        } else {
            return "error";
        }
        model.addAttribute("codesList", codesService.findAll());
        return "code";
    }
}
