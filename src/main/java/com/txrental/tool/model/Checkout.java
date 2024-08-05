package com.txrental.tool.model;

import java.time.LocalDate;

public class Checkout {

    private String toolCode;
    private int rentingDays;

    private double discountPercentage;

    private LocalDate checkOutDate;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getRentingDays() {
        return rentingDays;
    }

    public void setRentingDays(int rentingDays) {
        this.rentingDays = rentingDays;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


    public Checkout(String toolCode, int rentingDays, double discountPercentage, LocalDate checkOutDate) {
        this.toolCode = toolCode;
        this.rentingDays = rentingDays;
        this.discountPercentage = discountPercentage;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Checkout{toolCode=" + toolCode + ", rentingDays=" + rentingDays + ", discountPercentage=" + discountPercentage+ ", checkOutDate=" + checkOutDate + "}";
    }



}
