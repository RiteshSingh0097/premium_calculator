package com.ritesh.insurance.strategy;

import com.ritesh.insurance.enums.InsuranceType;

public interface InsuranceStrategy {
    double calculate(double costPrice);

    boolean accept(InsuranceType insuranceType);
}
