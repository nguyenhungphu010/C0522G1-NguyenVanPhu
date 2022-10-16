package com.controller;


import com.model.Product;
import com.service.impl.ProductService;
import com.service.impl.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(size = 5) Pageable pageable, @RequestParam(defaultValue = "") String searchParam,
                           Model model) {
        Page<Product> products = productService.findAll(pageable, searchParam);
        model.addAttribute("productList", products);
        System.out.println("abc");
        return "List";
    }

    @GetMapping("/showEdit")
    public String showEditForm (@RequestParam Integer id, Model model){
        Product products = productService.findById(id).orElse(null);
        model.addAttribute("product", products);
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "Edit";
    }

    @PostMapping("/saveUpdate")
    public String saveEdit(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/create")
    public String showCreateForm (Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "/Add";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product){
        this.productService.save(product);
        return "redirect:/products/list";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer idProduct){
        this.productService.deleteById(idProduct);
        return "redirect:/products/list";
    }

}
