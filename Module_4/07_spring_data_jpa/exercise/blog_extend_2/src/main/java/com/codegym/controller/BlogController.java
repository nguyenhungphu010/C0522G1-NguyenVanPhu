package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.codegym.service.IFindBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private IBlogRepository blogRepository;


    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"/","/search"})
    public String listBlog(@RequestParam(required = false,defaultValue = "") String search,
                           @RequestParam(required = false,defaultValue = "0") Integer category, Model model,
                           @PageableDefault( sort = "id", direction = Sort.Direction.DESC, size = 5)
                                   Pageable pageable) {
        Category categoryServiceById = iCategoryService.findById(category);
        Page<Blog> page = iBlogService.findBlogPage(pageable,search,categoryServiceById);
        model.addAttribute("list", page);
        model.addAttribute("pageable", pageable);
        model.addAttribute("categorylist", iCategoryService.findAll());
        model.addAttribute("search", search);
        model.addAttribute("category", iCategoryService.findById(category));
        model.addAttribute("catelogy", category);
        return "list";
    }

    @GetMapping("/add")
    public String showAddBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorylist", iCategoryService.findAll());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/showEdit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id).get());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iBlogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/showDetails")
    public String showDetails(@RequestParam int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id).get());
        return "details";
    }

    @GetMapping("/list2")
    public String showDetails2(Model model){
//        List<IFindBlog> findBlogs = blogRepository.findBlogByContentAndCategory();
        model.addAttribute("listBlog",blogRepository.findBlogByContentAndCategory());
//        model.addAttribute("BlogContent",blogRepository.findBlogByContentAndCategory());
        return "/details2";
    }
}