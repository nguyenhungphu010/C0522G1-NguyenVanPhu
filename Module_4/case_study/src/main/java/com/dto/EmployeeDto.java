package com.dto;


import com.model.contract.Contract;
import com.model.employee.Division;
import com.model.employee.Education;
import com.model.employee.Position;
import com.util.FacilityValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class EmployeeDto implements Validator {

    private Integer id;
    @NotBlank(message = "please input the name !")
    private String name;
    private String dateOfBirth;
    @NotBlank(message = "please input the name !")
    private String idCard;
    private double salary;
    @Pattern(regexp = "^((090)|(091)|(\\(84\\)+90)|(\\(84\\)+91))[0-9]{7}$",
            message = "Please input the correct phone number !")
    private String phoneNumber;
    @Email(message = "please input the correct format: abc@gmail.com !")
    private String email;
    @NotBlank(message = "please input the address !")
    private String address;
    private Position position;
    private Education education;
    private Division division;
    private Set<Contract> contracts;


    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String dateOfBirth, String idCard, double salary, String phoneNumber, String email, String address, Position position, Education education, Division division, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.education = education;
        this.division = division;
        this.contracts = contracts;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
         String name = employeeDto.getName();
         if (!name.matches("^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*){0,20}$")){
             errors.rejectValue("name", "name","first letter must be capital");
         }
        String idCard = employeeDto.getIdCard();
        if (!idCard.matches("^[0-9]{9}|[0-9]{12}$")){
            errors.rejectValue("idCard", "idCard","ID Card must follow the correct pattern");
        }
        String dateOfBirth = employeeDto.getDateOfBirth();
        FacilityValidation.checkStartDate("dateOfBirth",dateOfBirth,errors);

        double salary = employeeDto.getSalary();
        FacilityValidation.checkDouble("salary", salary, errors);

    }
}
