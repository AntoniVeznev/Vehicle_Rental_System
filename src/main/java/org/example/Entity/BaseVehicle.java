package org.example.Entity;


import java.time.LocalDate;

public class BaseVehicle {
    private String type;
    private String brand;
    private String model;
    private double vehicleValue;
    private int rentalPeriodInDays;
    private String customerFullName;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDate actualReturnDate;
    private int additionalDetails;

    public BaseVehicle(String type, String brand, String model, double vehicleValue, int rentalPeriodInDays, String customerFullName, LocalDate reservationStartDate, LocalDate reservationEndDate, LocalDate actualReturnDate, int additionalDetails) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.vehicleValue = vehicleValue;
        this.rentalPeriodInDays = rentalPeriodInDays;
        this.customerFullName = customerFullName;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.actualReturnDate = actualReturnDate;
        this.additionalDetails = additionalDetails;
    }

    public String getType() {
        return type;
    }


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public double getVehicleValue() {
        return vehicleValue;
    }


    public int getRentalPeriodInDays() {
        return rentalPeriodInDays;
    }


    public String getCustomerFullName() {
        return customerFullName;
    }


    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }


    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }


    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }


    public int getAdditionalDetails() {
        return additionalDetails;
    }


}
