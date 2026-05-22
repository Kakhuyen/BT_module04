package com.codegym.mailsettings.controller;

import com.codegym.mailsettings.model.MailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {

    private MailSettings settings = new MailSettings(
            "English",
            25,
            false,
            "Thor\nKing, Asgard"
    );

    @GetMapping("/settings")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("settings");

        modelAndView.addObject("settings", settings);

        modelAndView.addObject("languages",
                new String[]{"English", "Vietnamese", "Japanese", "Chinese"});

        modelAndView.addObject("pageSizes",
                new int[]{5, 10, 15, 25, 50, 100});

        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("settings") MailSettings settings) {
        this.settings = settings;

        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("settings", settings);

        return modelAndView;
    }
}