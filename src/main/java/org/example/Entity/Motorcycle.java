package org.example.Entity;


import java.time.LocalDate;

public class Motorcycle extends BaseVehicle {
    private int age;

    public Motorcycle(String type, String brand, String model, double vehicleValue, int rentalPeriodInDays, String customerFullName, LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDate actualReturnDate, int additionalDetails) {
        super(type, brand, model, vehicleValue, rentalPeriodInDays, customerFullName, reservationStartDate, reservationEndDate, actualReturnDate, additionalDetails);
    }


    public int getAge() {
        return age;
    }

    public Motorcycle setAge(int age) {
        this.age = age;
        return this;
    }
}
