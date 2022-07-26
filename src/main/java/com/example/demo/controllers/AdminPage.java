package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPage {

    @GetMapping("admin")
    String index() {
        return "index.html";
    }
}
