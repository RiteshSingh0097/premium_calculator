package com.ritesh.insurance.strategy.impl;

import com.ritesh.insurance.enums.InsuranceType;
import com.ritesh.insurance.strategy.InsuranceStrategy;

public class PremiumInsuranceType implements InsuranceStrategy {

    @Override
    public double calculate(double costPrice) {
        return (costPrice+ (costPrice * 0.2));
    }

    @Override
    public boolean accept(InsuranceType insuranceType) {
        return InsuranceType.PREMIUM.equals(insuranceType);
    }
}
