package com.example.ss1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Hello {
    @GetMapping
    public String sayHello() {
        return "/index";
    }
}
