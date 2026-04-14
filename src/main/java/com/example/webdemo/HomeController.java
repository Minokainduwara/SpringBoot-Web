package com.example.webdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to the Home Page";
    }

    @RequestMapping("/about")
    public String About(){
        return "About Us Page";
    }
}
