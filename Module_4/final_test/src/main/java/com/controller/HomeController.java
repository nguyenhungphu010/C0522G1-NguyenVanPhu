package com.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
public class HomeController {

    @GetMapping("/home")
    public String showHome(){
        return "/home";
    }
}
