package com.example.demo.hospital.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // This maps to index.html in src/main/resources/templates
    }
    @GetMapping("/login")
    public String login() {
        return "login"; // This maps to login.html in src/main/resources/templates
    }
}
