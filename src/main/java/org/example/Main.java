package org.example;


import org.example.Entity.BaseVehicle;
import org.example.Entity.Car;
import org.example.Entity.CargoVan;
import org.example.Entity.Motorcycle;
import org.example.Input.InputValues;
import org.example.Constants.MagicStrings;


public class Main {
    public static void main(String[] args) {

        BaseVehicle vehicle = createVehicle();

        switch (vehicle.getType()) {

            case MagicStrings.CAR -> {
                Car car = createCar(vehicle);
                buildDataForCar(car, vehicle);
            }

            case MagicStrings.MOTORCYCLE -> {
                Motorcycle motorcycle = createMotorcycle(vehicle);
                buildDataForMotorcycle(motorcycle, vehicle);
            }

            case MagicStrings.CARGO_VAN -> {
                CargoVan cargoVan = createCargoVan(vehicle);
                buildDataForCargoVan(cargoVan, vehicle);
            }

            default -> System.out.println(MagicStrings.WRONG_VEHICLE);
        }
    }

    private static BaseVehicle createVehicle() {

        return new BaseVehicle(
                InputValues.VEHICLE_TYPE,
                InputValues.VEHICLE_BRAND,
                InputValues.VEHICLE_MODEL,
                InputValues.VEHICLE_VALUE,
                InputValues.RENTAL_PERIOD_IN_DAYS,
                InputValues.CUSTOMER_FULL_NAME,
                InputValues.RESERVATION_START_DATE,
                InputValues.RESERVATION_END_DATE,
                InputValues.ACTUAL_RETURN_DATE,
                InputValues.ADDITIONAL_DETAILS);

    }

    private static Car createCar(BaseVehicle baseVehicle) {

        Car car = new Car(baseVehicle.getType(), baseVehicle.getBrand(), baseVehicle.getModel(),
                baseVehicle.getVehicleValue(), baseVehicle.getRentalPeriodInDays(),
                baseVehicle.getCustomerFullName(), baseVehicle.getReservationStartDate(),
                baseVehicle.getReservationEndDate(), baseVehicle.getActualReturnDate(), baseVehicle.getAdditionalDetails());

        car
                .setCarRating(baseVehicle.getAdditionalDetails())
                .changeSafetyRating();

        return car;

    }

    private static Motorcycle createMotorcycle(BaseVehicle baseVehicle) {

        Motorcycle motorcycle = new Motorcycle(baseVehicle.getType(), baseVehicle.getBrand(), baseVehicle.getModel(),
                baseVehicle.getVehicleValue(), baseVehicle.getRentalPeriodInDays(),
                baseVehicle.getCustomerFullName(), baseVehicle.getReservationStartDate(),
                baseVehicle.getReservationEndDate(), baseVehicle.getActualReturnDate(), baseVehicle.getAdditionalDetails());

        motorcycle
                .setAge(baseVehicle.getAdditionalDetails());

        return motorcycle;

    }

    private static CargoVan createCargoVan(BaseVehicle baseVehicle) {

        CargoVan cargoVan = new CargoVan(baseVehicle.getType(), baseVehicle.getBrand(), baseVehicle.getModel(),
                baseVehicle.getVehicleValue(), baseVehicle.getRentalPeriodInDays(),
                baseVehicle.getCustomerFullName(), baseVehicle.getReservationStartDate(),
                baseVehicle.getReservationEndDate(), baseVehicle.getActualReturnDate(), baseVehicle.getAdditionalDetails());

        cargoVan
                .setExperience(baseVehicle.getAdditionalDetails());

        return cargoVan;

    }

    private static void buildDataForCargoVan(CargoVan cargoVan, BaseVehicle vehicle) {

        StringBuilder builder = new StringBuilder();

        int actualRentalDays = cargoVan.getActualReturnDate().getDayOfMonth() - cargoVan.getReservationStartDate().getDayOfMonth();
        double rentalCostPerDay = 0;
        double insuranceCostPerDay = (0.03 * cargoVan.getVehicleValue()) / 100;


        if (vehicle.getRentalPeriodInDays() <= 7) {
            rentalCostPerDay += 50;

        } else {
            rentalCostPerDay += 40;

        }
        if (cargoVan.getExperience() > 5) {
            insuranceCostPerDay = insuranceCostPerDay * 0.85;

        }

        double initialInsurance = (0.03 * cargoVan.getVehicleValue()) / 100;
        double insuranceDiscountPerDay = ((0.03 * cargoVan.getVehicleValue()) / 100) - insuranceCostPerDay;
        double totalRent = rentalCostPerDay * actualRentalDays;
        double totalInsurance = insuranceCostPerDay * actualRentalDays;


        double earlyReturnDiscountForRent = (cargoVan.getRentalPeriodInDays() - actualRentalDays) * (rentalCostPerDay / 2);
        double earlyReturnDiscountForInsurance = (cargoVan.getRentalPeriodInDays() - actualRentalDays) * insuranceCostPerDay;
        double totalSum = totalRent + totalInsurance;

        builder.append(System.lineSeparator())
                .append(String.format(MagicStrings.CARGO_VAN_VALUE_AND_EXPERIENCE, cargoVan.getType(), cargoVan.getVehicleValue(), cargoVan.getExperience())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator())
                .append(String.format(MagicStrings.CURRENT_DATE, cargoVan.getActualReturnDate().getYear(), cargoVan.getActualReturnDate().getMonth().getValue(), cargoVan.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.CUSTOMER_NAME, cargoVan.getCustomerFullName())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTED_VEHICLE, cargoVan.getBrand(), cargoVan.getModel())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_START_DATE, cargoVan.getReservationStartDate().getYear(), cargoVan.getReservationStartDate().getMonth().getValue(), cargoVan.getReservationStartDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_END_DATE, cargoVan.getReservationEndDate().getYear(), cargoVan.getReservationEndDate().getMonth().getValue(), cargoVan.getReservationEndDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVED_RENTAL_DAYS, cargoVan.getRentalPeriodInDays())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RETURN_DATE, cargoVan.getActualReturnDate().getYear(), cargoVan.getActualReturnDate().getMonth().getValue(), cargoVan.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RENTAL_DAYS, actualRentalDays)).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTAL_COST_PER_DAY, rentalCostPerDay)).append(System.lineSeparator());

        if (cargoVan.getExperience() > 5) {
            builder.append(String.format(MagicStrings.INITIAL_INSURANCE_PER_DAY, initialInsurance)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.INSURANCE_DISCOUNT_PER_DAY, insuranceDiscountPerDay)).append(System.lineSeparator());
        }

        builder
                .append(String.format(MagicStrings.INSURANCE_PER_DAY, insuranceCostPerDay)).append(System.lineSeparator()).append(System.lineSeparator());

        if (cargoVan.getRentalPeriodInDays() != actualRentalDays) {

            totalRent += earlyReturnDiscountForRent;
            totalSum = totalRent + totalInsurance;
            builder.append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_RENT, earlyReturnDiscountForRent)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_INSURANCE, earlyReturnDiscountForInsurance)).append(System.lineSeparator()).append(System.lineSeparator());
        }

        builder.append(String.format(MagicStrings.TOTAL_RENT, totalRent)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL_INSURANCE, totalInsurance)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL, totalSum)).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator());

        System.out.println(builder);

    }

    private static void buildDataForMotorcycle(Motorcycle motorcycle, BaseVehicle vehicle) {

        StringBuilder builder = new StringBuilder();

        int actualRentalDays = motorcycle.getActualReturnDate().getDayOfMonth() - motorcycle.getReservationStartDate().getDayOfMonth();
        double rentalCostPerDay = 0;
        double insuranceCostPerDay = (0.02 * motorcycle.getVehicleValue()) / 100;


        if (vehicle.getRentalPeriodInDays() <= 7) {
            rentalCostPerDay += 15;

        } else {
            rentalCostPerDay += 10;

        }
        if (motorcycle.getAge() < 25) {
            insuranceCostPerDay = insuranceCostPerDay * 1.2;

        }


        double initialInsurance = (0.02 * motorcycle.getVehicleValue()) / 100;
        double insuranceAdditionPerDay = insuranceCostPerDay - (0.02 * motorcycle.getVehicleValue()) / 100;
        double totalRent = rentalCostPerDay * actualRentalDays;
        double totalInsurance = insuranceCostPerDay * actualRentalDays;

        double earlyReturnDiscountForRent = (motorcycle.getRentalPeriodInDays() - actualRentalDays) * (rentalCostPerDay / 2);
        double earlyReturnDiscountForInsurance = (motorcycle.getRentalPeriodInDays() - actualRentalDays) * insuranceCostPerDay;
        double totalSum = totalRent + totalInsurance;

        builder.append(System.lineSeparator())
                .append(String.format(MagicStrings.MOTORCYCLE_VALUE_AND_AGE, motorcycle.getType(), motorcycle.getVehicleValue(), motorcycle.getAge())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator())
                .append(String.format(MagicStrings.CURRENT_DATE, motorcycle.getActualReturnDate().getYear(), motorcycle.getActualReturnDate().getMonth().getValue(), motorcycle.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.CUSTOMER_NAME, motorcycle.getCustomerFullName())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTED_VEHICLE, motorcycle.getBrand(), motorcycle.getModel())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_START_DATE, motorcycle.getReservationStartDate().getYear(), motorcycle.getReservationStartDate().getMonth().getValue(), motorcycle.getReservationStartDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_END_DATE, motorcycle.getReservationEndDate().getYear(), motorcycle.getReservationEndDate().getMonth().getValue(), motorcycle.getReservationEndDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVED_RENTAL_DAYS, motorcycle.getRentalPeriodInDays())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RETURN_DATE, motorcycle.getActualReturnDate().getYear(), motorcycle.getActualReturnDate().getMonth().getValue(), motorcycle.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RENTAL_DAYS, actualRentalDays)).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTAL_COST_PER_DAY, rentalCostPerDay)).append(System.lineSeparator());

        if (motorcycle.getAge() < 25) {
            builder.append(String.format(MagicStrings.INITIAL_INSURANCE_PER_DAY, initialInsurance)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.INSURANCE_ADDITION_PER_DAY, insuranceAdditionPerDay)).append(System.lineSeparator());
        }

        builder
                .append(String.format(MagicStrings.INSURANCE_PER_DAY, insuranceCostPerDay)).append(System.lineSeparator()).append(System.lineSeparator());

        if (motorcycle.getRentalPeriodInDays() != actualRentalDays) {

            totalRent += earlyReturnDiscountForRent;
            totalSum = totalRent + totalInsurance;
            builder.append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_RENT, earlyReturnDiscountForRent)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_INSURANCE, earlyReturnDiscountForInsurance)).append(System.lineSeparator()).append(System.lineSeparator());
        }
        builder.append(String.format(MagicStrings.TOTAL_RENT, totalRent)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL_INSURANCE, totalInsurance)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL, totalSum)).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator());

        System.out.println(builder);

    }

    private static void buildDataForCar(Car car, BaseVehicle vehicle) {

        StringBuilder builder = new StringBuilder();

        int actualRentalDays = car.getActualReturnDate().getDayOfMonth() - car.getReservationStartDate().getDayOfMonth();
        double rentalCostPerDay = 0;
        double insuranceCostPerDay = (0.01 * car.getVehicleValue()) / 100;


        if (vehicle.getRentalPeriodInDays() <= 7) {
            rentalCostPerDay += 20;

        } else if (vehicle.getRentalPeriodInDays() > 7) {
            rentalCostPerDay += 15;

        }

        if (car.getHighCarSafetyRating()) {
            insuranceCostPerDay = insuranceCostPerDay * 0.9;

        }


        double insuranceDiscountPerDay = ((0.01 * car.getVehicleValue()) / 100) - insuranceCostPerDay;
        double initialInsurance = (0.01 * car.getVehicleValue()) / 100;
        double totalRent = rentalCostPerDay * actualRentalDays;
        double totalInsurance = insuranceCostPerDay * actualRentalDays;

        double earlyReturnDiscountForRent = (car.getRentalPeriodInDays() - actualRentalDays) * (rentalCostPerDay / 2);
        double earlyReturnDiscountForInsurance = (car.getRentalPeriodInDays() - actualRentalDays) * insuranceCostPerDay;
        double totalSum = totalRent + totalInsurance;

        builder.append(System.lineSeparator())
                .append(String.format(MagicStrings.CAR_VALUE_AND_RATING, car.getType(), car.getVehicleValue(), car.getCarRating())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator())
                .append(String.format(MagicStrings.CURRENT_DATE, car.getActualReturnDate().getYear(), car.getActualReturnDate().getMonth().getValue(), car.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.CUSTOMER_NAME, car.getCustomerFullName())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTED_VEHICLE, car.getBrand(), car.getModel())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_START_DATE, car.getReservationStartDate().getYear(), car.getReservationStartDate().getMonth().getValue(), car.getReservationStartDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVATION_END_DATE, car.getReservationEndDate().getYear(), car.getReservationEndDate().getMonth().getValue(), car.getReservationEndDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.RESERVED_RENTAL_DAYS, car.getRentalPeriodInDays())).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RETURN_DATE, car.getActualReturnDate().getYear(), car.getActualReturnDate().getMonth().getValue(), car.getActualReturnDate().getDayOfMonth())).append(System.lineSeparator())
                .append(String.format(MagicStrings.ACTUAL_RENTAL_DAYS, actualRentalDays)).append(System.lineSeparator()).append(System.lineSeparator())
                .append(String.format(MagicStrings.RENTAL_COST_PER_DAY, rentalCostPerDay)).append(System.lineSeparator());

        if (car.getHighCarSafetyRating()) {
            builder.append(String.format(MagicStrings.INITIAL_INSURANCE_PER_DAY, initialInsurance)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.INSURANCE_DISCOUNT_PER_DAY, insuranceDiscountPerDay)).append(System.lineSeparator());
        }

        builder.append(String.format(MagicStrings.INSURANCE_PER_DAY, insuranceCostPerDay)).append(System.lineSeparator()).append(System.lineSeparator());

        if (car.getRentalPeriodInDays() != actualRentalDays) {

            totalRent += earlyReturnDiscountForRent;
            totalSum = totalRent + totalInsurance;
            builder.append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_RENT, earlyReturnDiscountForRent)).append(System.lineSeparator())
                    .append(String.format(MagicStrings.EARLY_RETURN_DISCOUNT_INSURANCE, earlyReturnDiscountForInsurance)).append(System.lineSeparator()).append(System.lineSeparator());
        }

        builder.append(String.format(MagicStrings.TOTAL_RENT, totalRent)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL_INSURANCE, totalInsurance)).append(System.lineSeparator())
                .append(String.format(MagicStrings.TOTAL, totalSum)).append(System.lineSeparator())
                .append(MagicStrings.DELIMITER_X).append(System.lineSeparator());

        System.out.println(builder);

    }

}
