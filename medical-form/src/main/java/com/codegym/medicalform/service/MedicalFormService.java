package com.codegym.medicalform.service;

import com.codegym.medicalform.model.MedicalForm;
import org.springframework.stereotype.Service;

@Service
public class MedicalFormService {

    private MedicalForm medicalForm;

    public void save(MedicalForm form) {
        this.medicalForm = form;
    }

    public MedicalForm getForm() {
        return medicalForm;
    }
}