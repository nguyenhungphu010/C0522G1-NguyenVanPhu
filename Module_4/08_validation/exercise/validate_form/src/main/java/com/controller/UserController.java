package com.controller;

import com.dto.UserDto;
import com.model.User;
import com.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private IFormService formService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return"/index";
    }

    @PostMapping("/save")
    public String validateUser(@Validated @ModelAttribute(value = "userDto") UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return ("/index");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        formService.save(user);
        return "redirect:/form";
    }
}
