package com.controller;

import com.dto.CartDto;
import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("cart")// khai báo session cart.
@Controller
@RequestMapping("/")
public class ShoppingController {

//    khởi tạo giá trị mặc định cho session
    @ModelAttribute("cart")
    public CartDto initCart(){
        return  new CartDto();
    }
    @Autowired
    private IProductService productService;

    @GetMapping("list")
    public String showProduct(Model model, @CookieValue(value ="idProduct", defaultValue = "-1") Integer idProduct){
//        Product product = new Product();
        if (idProduct != -1){
            model.addAttribute("productHistory", productService.findById(idProduct).get());
        }
        List<Product > products = productService.findAll();
        model.addAttribute("productList", products);
        return "/home";
    }

}
