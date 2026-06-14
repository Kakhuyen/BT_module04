package com.codegym.cart.controller;

import com.codegym.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showProducts(Model model) {

        model.addAttribute(
                "products",
                productService.findAll()
        );

        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String showDetail(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "product",
                productService.findById(id)
        );

        return "product/detail";
    }
}