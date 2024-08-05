package com.txrental.tool.model;

public class RentalAmount {


    double rentalAmount = 0;
    int chargeDays=0;

    public RentalAmount(double rentalAmount, int chargeDays) {
        this.rentalAmount = rentalAmount;
        this.chargeDays = chargeDays;
    }

    public double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }



}
