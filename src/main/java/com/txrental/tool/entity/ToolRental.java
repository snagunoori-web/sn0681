package com.txrental.tool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ToolRental {
    private @Id @GeneratedValue Long id;
    private String toolType;

    private double dailyCharge;
    private String holidayCharge;

    private String weekdayCharge;

    private String weekendCharge;

    public ToolRental(){

    }
    public ToolRental(String toolType, double dailyCharge, String weekdayCharge, String weekendCharge, String holidayCharge) {
        this.toolType = toolType;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public String getWeekdayCharge() {
        return weekdayCharge;
    }

    public void setWeekdayCharge(String weekdayCharge) {
        this.weekdayCharge = weekdayCharge;
    }

    public String getWeekendCharge() {
        return weekendCharge;
    }

    public void setWeekendCharge(String weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public String getHolidayCharge() {
        return holidayCharge;
    }

    public void setHolidayCharge(String holidayCharge) {
        this.holidayCharge = holidayCharge;
    }


    @Override
    public String toString() {
        return "ToolRental{" +
                "id=" + id +
                ", toolType='" + toolType + '\'' +
                ", dailyCharge=" + dailyCharge +
                ", weekdayCharge='" + weekdayCharge + '\'' +
                ", weekendCharge='" + weekendCharge + '\'' +
                ", holidayCharge='" + holidayCharge + '\'' +
                '}';
    }


}
