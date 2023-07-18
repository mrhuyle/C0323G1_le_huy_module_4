package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public String show() {
        return "show";
    }

    @PostMapping("/find")
    public String find(@RequestParam String word, @RequestParam String type, Model model) {
        String translateWord = dictionaryService.find(word,type);
        model.addAttribute("translateWord", translateWord);
        model.addAttribute("word", word);
        return "show";
    }

}
