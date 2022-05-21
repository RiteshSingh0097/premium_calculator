package com.ritesh.insurance.strategy.impl;

import com.ritesh.insurance.enums.InsuranceType;
import com.ritesh.insurance.strategy.InsuranceStrategy;

public class BasicInsuranceType implements InsuranceStrategy {
    @Override
    public double calculate(double costPrice) {
        return costPrice;
    }

    @Override
    public boolean accept(InsuranceType insuranceType) {
        return InsuranceType.BASIC.equals(insuranceType);
    }
}
