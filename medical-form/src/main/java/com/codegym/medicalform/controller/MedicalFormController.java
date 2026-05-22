package com.codegym.medicalform.controller;

import com.codegym.medicalform.model.MedicalForm;
import com.codegym.medicalform.service.MedicalFormService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medical")
public class MedicalFormController {

    @Autowired
    private MedicalFormService medicalFormService;

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("medicalForm", new MedicalForm());
        return "medical-form";
    }

    @PostMapping("/save")
    public String saveForm(@Valid @ModelAttribute MedicalForm medicalForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "medical-form";
        }

        medicalFormService.save(medicalForm);
        return "redirect:/medical/view";
    }

    @GetMapping("/view")
    public String viewForm(Model model) {
        model.addAttribute("medicalForm", medicalFormService.getForm());
        return "medical-view";
    }

    @GetMapping("/edit")
    public String editForm(Model model) {
        model.addAttribute("medicalForm", medicalFormService.getForm());
        return "medical-form";
    }
}