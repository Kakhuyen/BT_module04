package com.codegym.currencyconverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String showForm() {

        return "index";
    }

    @GetMapping("/convert")
    public String convert(

            @RequestParam("usd") double usd,

            @RequestParam("rate") double rate,

            Model model) {

        double vnd = usd * rate;

        model.addAttribute("result", vnd);

        return "result";
    }
}