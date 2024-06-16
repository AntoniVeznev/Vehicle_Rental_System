package org.example.Entity;


import java.time.LocalDate;

public class CargoVan extends BaseVehicle {
    private int experience;

    public CargoVan(String type, String brand, String model, double vehicleValue, int rentalPeriodInDays, String customerFullName, LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDate actualReturnDate, int additionalDetails) {
        super(type, brand, model, vehicleValue, rentalPeriodInDays, customerFullName, reservationStartDate, reservationEndDate, actualReturnDate, additionalDetails);
    }


    public int getExperience() {
        return experience;
    }

    public CargoVan setExperience(int experience) {
        this.experience = experience;
        return this;
    }
}
