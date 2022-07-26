package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPage {

    @GetMapping("user")
    String index() {
        return "index.html";
    }
}