package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PhoneController {

    @GetMapping("/list")
    public String showIndex(){
        return "index";
    }
}
