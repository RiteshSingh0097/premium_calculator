package com.ritesh.insurance;

import com.ritesh.insurance.entity.Car;
import com.ritesh.insurance.enums.CarType;
import com.ritesh.insurance.enums.InsuranceType;
import com.ritesh.insurance.strategy.CarTypeStrategy;
import com.ritesh.insurance.strategy.InsuranceStrategy;
import com.ritesh.insurance.strategy.impl.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class PremiumCalculatorApplication {


    private static final Collection<InsuranceStrategy> insuranceStrategy =
            List.of(new BasicInsuranceType(), new PremiumInsuranceType());
    private static final Collection<CarTypeStrategy> carTypeStrategy =
            List.of(new HatchbackCarType(), new SuvCarType(), new SedanCarType());

    public static void main(String[] args) {
        //  SpringApplication.run(PremiumCalculatorApplication.class, args);

        Scanner sc = new Scanner(System.in);
        boolean newCar;
        do {
            Car car = new Car();
            System.out.print("Enter car model :: ");
            car.setModel(sc.nextLine());
            System.out.print("Enter car type :: ");
            String carType = sc.nextLine();
            try {
                car.setCarType(CarType.valueOf(carType));
            } catch (Exception e) {
                throw new IllegalStateException("Invalid car type :: " + carType);
            }
            System.out.print("Enter insurance type :: ");
            String insuranceType = sc.nextLine();
            try {
                car.setInsuranceType(InsuranceType.valueOf(insuranceType));
            } catch (Exception e) {
                throw new IllegalStateException("Invalid insurance type :: " + insuranceType);
            }
            System.out.print("Enter cost price :: ");
            car.setCostPrice(sc.nextDouble());
            System.out.println(
                    "Your insurance premium will be :: " + calculate(car));
            System.out.print("Do you want to enter details of any other car (y/n): ");
            newCar = "y".equals(sc.next());
            sc.nextLine();
        } while (newCar);
    }

    public static double calculate(Car car) {
        Optional<InsuranceStrategy> insuranceType =
                insuranceStrategy.stream()
                        .filter(insurance -> insurance.accept(car.getInsuranceType()))
                        .findFirst();

        Optional<CarTypeStrategy> carType =
                carTypeStrategy.stream().filter(carTypes -> carTypes.accept(car.getCarType())).findFirst();

        return insuranceType
                .orElseThrow(IllegalStateException::new)
                .calculate(carType.orElseThrow(IllegalStateException::new).calculate(car.getCostPrice()));
    }

}
