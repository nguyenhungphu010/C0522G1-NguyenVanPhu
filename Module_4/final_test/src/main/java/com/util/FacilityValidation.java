package com.util;

import org.springframework.validation.Errors;

import java.time.LocalDate;

public class FacilityValidation {

    private static final String FACILITY_NAME_REGEX = "^([A-Z]\\w*)+(\\s[A-Z]\\w*)*$";

    public static void checkFacilityName(String field, String facilityName, Errors error) {
        if (facilityName.equals("")) {
            error.rejectValue(field, "field.create", "input the name please");
        } else if (!facilityName.matches(FACILITY_NAME_REGEX)) {
            error.rejectValue(field, "field.create", "First letter must be capital");
        }
    }

    public static void checkStartDate(String field, String startDate, Errors errors) {
        LocalDate now = LocalDate.now();

        if (startDate.equals("")) {
            errors.rejectValue(field, "startDate.create", "Input the Date again");
        } else {
            LocalDate startDate1 = LocalDate.parse(startDate);
            if (startDate1.compareTo(now) < 0) {
                errors.rejectValue(field, "startDate.create", "do not input the past");
            }
        }
    }

    public static void checkEndDate(String field, String endDate, String startDate, Errors errors) {
        if (endDate.equals("")) {
            errors.rejectValue(field, "endDate.create", "Please input the end Date");
        } else if (endDate.compareTo(startDate) < 0) {
            errors.rejectValue(field, "endDate.create", "Wrong End Date");
        }
    }
    public static void checkDouble(String field, Double value, Errors errors){
        if (value == null){
            errors.rejectValue(field, "field", "please input");
        } else if (value <0){
            errors.rejectValue(field, "field", "must be greater than 0");
        }
    }

    public static void checkInteger (String field, String value, Errors errors){
        if (!value.matches("[0-9]+")){
            errors.rejectValue(field, "field.create", "must be greater than 0");
        }

    }
}
