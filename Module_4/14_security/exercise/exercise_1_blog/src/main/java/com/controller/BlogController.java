package com.controller;


import com.model.Blog;
import com.service.IBlogService;
import com.service.impl.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.function.Predicate;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;


    @GetMapping("/")
    public String showIndex(Model model, Pageable pageable, Principal principal) {
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        model.addAttribute("list", blogPage);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iBlogService.remove(id);
        return "redirect:/blog/";
    }

    @GetMapping("/add")
    public String showAddBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "add new successfully");
        return "redirect:/blog/";
    }

    @GetMapping("/showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        Blog blog = new Blog();
        blog = iBlogService.findById(id).get();
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit successfully");
        return "redirect:/blog/";
    }
}
