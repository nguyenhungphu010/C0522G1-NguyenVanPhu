package com.dto;

import com.util.FacilityValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {

    private static  String regax ="([\\p{Lu}][\\p{Ll}0-9]{1,8})(\\s([\\p{Lu}0-9]|[\\p{Lu}0-9][\\p{Ll}0-9]{1,10})){0,5}$";

    private Integer id;
    @NotBlank(message = "please input the name")
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    @NotBlank(message = "please input !")
    @Pattern(regexp = "^((090)|(091)|(\\(84\\)+90)|(\\(84\\)+91))[0-9]{7}$",
            message = "Please input the correct phone number")
    private String phoneNumber;
    @NotBlank(message = "please input !")
    @Email(message = "please input the correct format: abc@gmail.com")
    private String email;
    @NotBlank(message = "please input the address !")
    private String address;
    private boolean isDeleted;

    private CustomerTypeDto customerTypeDto;

    public CustomerDto(Integer id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, Boolean isDeleted, CustomerTypeDto customerTypeDto) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isDeleted = isDeleted;
        this.customerTypeDto = customerTypeDto;
    }

    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public CustomerTypeDto getCustomerTypeDto() {
        return customerTypeDto;
    }

    public void setCustomerTypeDto(CustomerTypeDto customerTypeDto) {
        this.customerTypeDto = customerTypeDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        String name = customerDto.getName();
        if (!name.matches("^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*){0,20}$")){
            errors.rejectValue("name", "name.create","first letter must be capital");
        }
        String idCard = customerDto.getIdCard();
        if (!idCard.matches("^[0-9]{9}|[0-9]{12}$")){
            errors.rejectValue("idCard", "idCard.create","ID Card must follow the correct pattern");
        }

        String birthDay = customerDto.getDateOfBirth();
        FacilityValidation.checkStartDate("dateOfBirth",dateOfBirth,errors);
    }
}
