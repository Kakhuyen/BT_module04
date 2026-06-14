package com.codegym.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("cart")
public class CheckoutController {

    @PostMapping("/checkout")
    public String finishCheckout(SessionStatus status) {
        status.setComplete();
        return "redirect:/success";
    }
}