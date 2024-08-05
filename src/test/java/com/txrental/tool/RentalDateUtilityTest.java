package com.txrental.tool;

import com.txrental.tool.util.RentalDateUtility;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalDateUtilityTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Test
    public void testIsLabourDay_PositiveCase() {

        String date = "02/09/2024"; // 2024 Labor Day
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isLaborDay = RentalDateUtility.isLabourDay(localDate);
        Assert.assertTrue(isLaborDay);
    }

    @Test
    public void testIsLabourDay_NegativeCase() {

        String date = "02/08/2024";
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isLaborDay = RentalDateUtility.isLabourDay(localDate);
        Assert.assertFalse(isLaborDay);

    }


    @Test
    public void testIsDayJuly4thAndWeekDay() {

        // dd/MM/yyyy
        String date = "04/07/2022"; //  July 4 , 2022  is on Monday
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isDayJuly4thAndWeekDay = RentalDateUtility.isDayJuly4thAndWeekDay(localDate);
        Assert.assertTrue(isDayJuly4thAndWeekDay);
    }


    @Test
    public void testIsDayJuly4thAndWeekDay_Negative() {

        // dd/MM/yyyy
        String date = "04/07/2021"; //  July 4 , 2021  is on Sunday
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isDayJuly4thAndWeekDay = RentalDateUtility.isDayJuly4thAndWeekDay(localDate);
        Assert.assertFalse(isDayJuly4thAndWeekDay);
    }



    @Test
    public void testisNextDayJuly4thOnSaturday() {

        // dd/MM/yyyy
        String date = "03/07/2020"; //  July 4 , 2020  is on Saturday
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isNextDayJuly4thOnSaturday = RentalDateUtility.isNextDayJuly4thOnSaturday(localDate);
        Assert.assertTrue(isNextDayJuly4thOnSaturday);
    }


    @Test
    public void testisPreviosDayJuly4thOnSunday() {

        // dd/MM/yyyy
        String date = "05/07/2021"; //  July 4 , 2020  is on Saturday
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        boolean isPreviosDayJuly4thOnSunday = RentalDateUtility.isPreviosDayJuly4thOnSunday(localDate);
        Assert.assertTrue(isPreviosDayJuly4thOnSunday);
    }


}
