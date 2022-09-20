package com.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    @NotEmpty
    @NotBlank(message = "bắt buộc nhập")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z]+", message = "Wrong format !!! (@Pattern)")
    private String firstName;

    @NotEmpty
    @NotBlank(message = "bắt buộc nhập")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z]+", message = "Wrong format !!! (@Pattern)")
    private String lastName;

    private long phoneNumb;

    @Min(18)
    private int age;

    @Email
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(long phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!userDto.firstName.matches("[A-Za-z ]+")){
            errors.rejectValue("name",
                    "create.name",
                    "wrong format name !! (custom)");
        }
    }
}
