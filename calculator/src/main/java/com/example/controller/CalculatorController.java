package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/calculate")
    public String calculate(
            @RequestParam("number1") double number1,
            @RequestParam("number2") double number2,
            @RequestParam("operator") String operator,
            Model model) {

        double result = 0;

        switch (operator) {

            case "+":
                result = number1 + number2;
                break;

            case "-":
                result = number1 - number2;
                break;

            case "*":
                result = number1 * number2;
                break;

            case "/":
                result = number1 / number2;
                break;
        }

        model.addAttribute("result", result);

        return "index";
    }
}