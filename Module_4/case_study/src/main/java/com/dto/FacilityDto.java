package com.dto;

import com.model.facility.FacilityType;
import com.model.facility.RentType;
import com.util.FacilityValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class FacilityDto implements Validator {

    private int id;
    @NotBlank(message = "please input the Facility")
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String desConvenience;
    private Double poolArea;
    private int floors;
    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, double cost, int maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String desConvenience, Double poolArea, int floors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.desConvenience = desConvenience;
        this.poolArea = poolArea;
        this.floors = floors;
        this.facilityFree = facilityFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDesConvenience() {
        return desConvenience;
    }

    public void setDesConvenience(String desConvenience) {
        this.desConvenience = desConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        FacilityDto facilityDto = (FacilityDto) target;

        String maxPeople = String.valueOf(facilityDto.getMaxPeople());
        FacilityValidation.checkInteger("maxPeople", maxPeople, errors);

        String area = String.valueOf(facilityDto.getArea());
        FacilityValidation.checkInteger("area", area, errors);

        Double cost = facilityDto.getCost();
        FacilityValidation.checkDouble("cost",cost,errors);

        String serviceName= facilityDto.getName();
        FacilityValidation.checkFacilityName("name",serviceName,errors);

        if (facilityDto.getFacilityType() != null){
            int facilityTypeId = facilityDto.getFacilityType().getId();
            if (facilityTypeId <2 ){
                Double poolArea = facilityDto.getPoolArea();
                FacilityValidation.checkDouble("poolArea",poolArea,errors);
            }
            if (facilityTypeId<3){
                String numberOfFloor = String.valueOf(facilityDto.getFloors());
                FacilityValidation.checkInteger("floors", numberOfFloor, errors);
            }
        }

    }
}
