package com.codegym.cart.controller;

import com.codegym.cart.model.Cart;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cart/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.addProduct(product);
        }
        return "redirect:/cart";
    }

    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.decreaseProduct(product);
        }
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.removeProduct(product);
        }
        return "redirect:/cart";
    }
}