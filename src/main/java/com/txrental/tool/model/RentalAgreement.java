package com.txrental.tool.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/*
  Description & Purpose of the properties
● Tool code - Specified at checkout
● Tool type - From tool info
● Tool brand - From tool info
● Rental days - Specified at checkout
● Check out date - Specified at checkout
● Due date - Calculated from checkout date and rental days.
● Daily rental charge - Amount per day, specified by the tool type.
● Charge days - Count of chargeable days, from day after checkout through and including due
date, excluding “no charge” days as specified by the tool type.
● Pre-discount charge - Calculated as charge days X daily charge. Resulting total rounded half up
to cents.
● Discount percent - Specified at checkout.
● Discount amount - calculated from discount % and pre-discount charge. Resulting amount
rounded half up to cents.
● Final charge - Calculated as pre-discount charge - discount amount.
 */
public class RentalAgreement {

    private String toolCode;
    private String toolType;
    private String brand;
    private int rentalDays;
    private String checkOutDate;

    private String dueDate;

    private String dailyRentalCharge;

    private int chargeDays;

    private String preDiscountCharge;

    private String discountPercent;

    private String discountAmount;

    public String getFinalCharge() {
        return finalCharge;
    }

    private static final Logger log = LoggerFactory.getLogger(RentalAgreement.class);

    public void setFinalCharge(String finalCharge) {
        this.finalCharge = finalCharge;
    }

    private String finalCharge;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(String dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public String getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(String preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalAgreement that)) return false;
        return getRentalDays() == that.getRentalDays() && getChargeDays() == that.getChargeDays() && Objects.equals(getToolCode(), that.getToolCode()) && Objects.equals(getToolType(), that.getToolType()) && Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getCheckOutDate(), that.getCheckOutDate()) && Objects.equals(getDueDate(), that.getDueDate()) && Objects.equals(getDailyRentalCharge(), that.getDailyRentalCharge()) && Objects.equals(getPreDiscountCharge(), that.getPreDiscountCharge()) && Objects.equals(getDiscountPercent(), that.getDiscountPercent()) && Objects.equals(getDiscountAmount(), that.getDiscountAmount()) && Objects.equals(getFinalCharge(), that.getFinalCharge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getToolCode(), getToolType(), getBrand(), getRentalDays(), getCheckOutDate(), getDueDate(), getDailyRentalCharge(), getChargeDays(), getPreDiscountCharge(), getDiscountPercent(), getDiscountAmount(), getFinalCharge());
    }

    @Override
    public String toString() {
        return " \n ---------------------------------------------   " +"\n"+
                 "                RentalAgreement     " +"\n"+
                " Tool Code: " + toolCode +"\n"+
                " Tool Type: " + toolType +"\n"+
                " Brand: " + brand +"\n"+
                " Rental Days: " + rentalDays +
                " CheckOut Date: " + checkOutDate +"\n"+
                " Due Date: " + dueDate +"\n"+
                " Daily Rental Charge: " + dailyRentalCharge +"\n"+
                " Charge Days: " + chargeDays +"\n"+
                " PreDiscount Charge: " + preDiscountCharge +"\n"+
                " Discount Percent: " + discountPercent +"\n"+
                " Discount Amount: " + discountAmount +"\n"+
                " Final Charge: " + finalCharge +"\n" +
                " \n ---------------------------------------------   ";
    }


}
