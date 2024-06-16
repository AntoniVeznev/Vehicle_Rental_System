package org.example.Entity;


import java.time.LocalDate;

public class Car extends BaseVehicle {
    private int carRating;
    private boolean highCarSafetyRating = false;

    public Car(String type, String brand, String model, double vehicleValue, int rentalPeriodInDays, String customerFullName, LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDate actualReturnDate, int additionalDetails) {
        super(type, brand, model, vehicleValue, rentalPeriodInDays, customerFullName, reservationStartDate, reservationEndDate, actualReturnDate, additionalDetails);
    }


    public void changeSafetyRating() {
        if (carRating > 3) {
            setHighCarSafetyRating(true);
        }
    }

    public int getCarRating() {
        return carRating;
    }

    public Car setCarRating(int carRating) {
        this.carRating = carRating;
        return this;
    }

    public boolean getHighCarSafetyRating() {
        return highCarSafetyRating;
    }

    public Car setHighCarSafetyRating(boolean highCarSafetyRating) {
        this.highCarSafetyRating = highCarSafetyRating;
        return this;
    }


}
