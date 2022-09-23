package com.controller;

import com.dto.CartDto;
import com.dto.ProductDto;
import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SessionAttributes("cart")// khai báo session cart.
@Controller
@RequestMapping(value = "/")
public class ShoppingController {

//    khởi tạo giá trị mặc định cho session
    @ModelAttribute("cart")
    public CartDto initCart(){
        return  new CartDto();
    }


    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String showProduct(Model model, @CookieValue(value ="idProduct", defaultValue = "-1") Integer idProduct){
//        Product product = new Product();
        if (idProduct != -1){
            model.addAttribute("productHistory", productService.findById(idProduct).get());
        }
        List<Product > products = productService.findAll();
        model.addAttribute("productList", products);
        return "home";
    }
    @PostMapping("/details")
    public String showDetail(@RequestParam int productId, Model model){
        model.addAttribute("productDetail",productService.findById(productId));
        return "redirect:/list";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,@ModelAttribute("cart") CartDto cartDto){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(),productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}
