package com.ritesh.insurance.strategy.impl;

import com.ritesh.insurance.enums.CarType;
import com.ritesh.insurance.strategy.CarTypeStrategy;

public class SedanCarType implements CarTypeStrategy {
    @Override
    public double calculate(double costPrice) {
        return costPrice * 0.08;
    }

    @Override
    public boolean accept(CarType carType) {
        return CarType.SEDAN.equals(carType);
    }
}
