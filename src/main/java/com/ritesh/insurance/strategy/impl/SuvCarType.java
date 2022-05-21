package com.ritesh.insurance.strategy.impl;

import com.ritesh.insurance.enums.CarType;
import com.ritesh.insurance.strategy.CarTypeStrategy;

public class SuvCarType implements CarTypeStrategy {
    @Override
    public double calculate(double costPrice) {
        return costPrice * 0.1;
    }

    @Override
    public boolean accept(CarType carType) {
        return CarType.SUV.equals(carType);
    }
}
