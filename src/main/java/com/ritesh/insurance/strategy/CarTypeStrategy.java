package com.ritesh.insurance.strategy;

import com.ritesh.insurance.enums.CarType;

public interface CarTypeStrategy {
    double calculate(double costPrice);

    boolean accept(CarType carType);
}
