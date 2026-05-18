package com.codegym.productmanagement.controller;

import com.codegym.productmanagement.model.Product;
import com.codegym.productmanagement.service.IProductService;
import com.codegym.productmanagement.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService =
            new ProductService();

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute(
                "products",
                productService.findAll());

        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute(
                "product",
                new Product());

        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product,
                       RedirectAttributes redirect) {

        product.setId(
                (int)(Math.random() * 10000));

        productService.save(product);

        redirect.addFlashAttribute(
                "success",
                "Added successfully!");

        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,
                       Model model) {

        model.addAttribute(
                "product",
                productService.findById(id));

        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product,
                         RedirectAttributes redirect) {

        productService.update(
                product.getId(),
                product);

        redirect.addFlashAttribute(
                "success",
                "Updated successfully!");

        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,
                         Model model) {

        model.addAttribute(
                "product",
                productService.findById(id));

        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product,
                                RedirectAttributes redirect) {

        productService.remove(product.getId());

        redirect.addFlashAttribute(
                "success",
                "Deleted successfully!");

        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,
                       Model model) {

        model.addAttribute(
                "product",
                productService.findById(id));

        return "/view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String keyword,
                         Model model) {

        model.addAttribute(
                "products",
                productService.searchByName(keyword));

        return "/index";
    }
}