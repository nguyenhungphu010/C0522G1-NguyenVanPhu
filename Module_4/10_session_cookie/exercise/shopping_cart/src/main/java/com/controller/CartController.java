package com.controller;

import com.dto.CartDto;
import com.dto.ProductDto;
import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(@SessionAttribute(name = "cart", required = false) CartDto cartDto, Model model) {
        model.addAttribute("cart", cartDto);
        return "/cart";
    }

    @GetMapping("/increase/{id}")
    public String increaseProduct(@PathVariable Integer id,
                                  @SessionAttribute("cart") CartDto cartDto){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cartDto.addProduct(productDto); // thêm sản phẩm vào giỏ hàng.
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseProduct(@PathVariable Integer id,
                                  @SessionAttribute("cart") CartDto cartDto){

        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product.get(), productDto);
            cartDto.decreaseProduct(productDto); // bớt sản phẩm vào giỏ hàng.
        }
        return "redirect:/cart";
    }
}
