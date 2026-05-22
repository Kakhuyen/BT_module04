package com.codegym.medicalform.model;

import jakarta.validation.constraints.NotBlank;

public class MedicalForm {

    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @NotBlank(message = "Năm sinh không được để trống")
    private String birthYear;

    @NotBlank(message = "Giới tính không được để trống")
    private String gender;

    @NotBlank(message = "Quốc tịch không được để trống")
    private String nationality;

    @NotBlank(message = "CMND/Hộ chiếu không được để trống")
    private String idCard;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Điện thoại không được để trống")
    private String phone;

    @NotBlank(message = "Email không được để trống")
    private String email;

    public MedicalForm() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}