package com.codegym.customermanagementthymeleaf.controller;

import com.codegym.customermanagementthymeleaf.model.Customer;
import com.codegym.customermanagementthymeleaf.service.CustomerService;
import com.codegym.customermanagementthymeleaf.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService customerService =
            new CustomerService();

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute(
                "customers",
                customerService.findAll());

        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute(
                "customer",
                new Customer());

        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer,
                       RedirectAttributes redirect) {

        customer.setId(
                (int)(Math.random() * 10000));

        customerService.save(customer);

        redirect.addFlashAttribute(
                "success",
                "Added customer successfully!");

        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,
                       Model model) {

        model.addAttribute(
                "customer",
                customerService.findById(id));

        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer,
                         RedirectAttributes redirect) {

        customerService.update(
                customer.getId(),
                customer);

        redirect.addFlashAttribute(
                "success",
                "Updated customer successfully!");

        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,
                         Model model) {

        model.addAttribute(
                "customer",
                customerService.findById(id));

        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(Customer customer,
                                 RedirectAttributes redirect) {

        customerService.remove(customer.getId());

        redirect.addFlashAttribute(
                "success",
                "Deleted customer successfully!");

        return "redirect:/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,
                       Model model) {

        model.addAttribute(
                "customer",
                customerService.findById(id));

        return "/view";
    }
}