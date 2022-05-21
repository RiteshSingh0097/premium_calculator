package com.ritesh.insurance.entity;

import com.ritesh.insurance.enums.CarType;
import com.ritesh.insurance.enums.InsuranceType;

public class Car {
    private String model;
    private InsuranceType insuranceType;
    private CarType carType;
    private double costPrice;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='"
                + model
                + '\''
                + ", insuranceType="
                + insuranceType
                + ", carType="
                + carType
                + ", costPrice="
                + costPrice
                + '}';
    }
}