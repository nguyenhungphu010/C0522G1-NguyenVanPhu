package com.controller;

import com.dto.UserDto;
import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new UserDto());
        return  modelAndView;
    }
    @PostMapping("validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") UserDto user,
                                        BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return  new ModelAndView("index");
        }else
            return new ModelAndView("/result");
    }

}
