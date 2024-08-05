package com.txrental.tool.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class RentalDateUtility {


    public static  void main(String args[]){

        //default, ISO_LOCAL_DATE
      /*  LocalDate july4weekDay_localDate = LocalDate.parse("2022-07-04");
        System.out.println(july4weekDay_localDate);

        LocalDate july4weekEnd_localDate = LocalDate.parse("2020-07-04");
        System.out.println("july4weekEnd_localDate" + july4weekEnd_localDate);

        System.out.println("---------------------------------------");
        System.out.println("isDayJuly4thAndWeekDay "+isDayJuly4thAndWeekDay(LocalDate.parse("2022-07-04")));

        System.out.println("---------------------------------------");
        System.out.println("isNextDayJuly4thOnSaturday " +isNextDayJuly4thOnSaturday(LocalDate.parse("2020-07-03")));

        System.out.println("---------------------------------------");
        System.out.println("isPreviosDayJuly4thOnSunday " +isPreviosDayJuly4thOnSunday(LocalDate.parse("2021-07-05")));
        System.out.println("---------------------------------------");

        System.out.println("isLabourDay " +isLabourDay(LocalDate.parse("2024-09-02")));
        System.out.println("---------------------------------------");


       */
       // rentalCalculation(LocalDate.parse("2022-07-01"), 5, 1.99);
        System.out.println("---------------------------------------");

        double amount = 200;
        double percentage = 15;

    }


    /**
     *  To check and return whether they given date is Labor Holiday or Not
     * @param localDate
     * @return
     */
    public static boolean isLabourDay(LocalDate localDate){
        Month month = localDate.getMonth();
        LocalDate firstMonday = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        if( "SEPTEMBER".equals(month.toString()) && firstMonday.equals(localDate)){
            return true;
        }

        return false;

    }


    /**
     *  To check whether given date is July 4 and on Is on Weekday
     * @param localDate
     * @return
     */
    public static boolean isDayJuly4thAndWeekDay(LocalDate localDate){
        int day = localDate.getDayOfMonth();
        Month month = localDate.getMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return day == 4 && "JULY".equals(month.toString()) && !"SATURDAY".equals(dayOfWeek.toString()) && !"SUNDAY".equals(dayOfWeek.toString());
    }

    /**
     *  To check whether given date is July 4 and on Is on Weekend
     * @param localDate
     * @return
     */
    public static boolean isDayJuly4thAndWeekend(LocalDate localDate){
        System.out.println("LocalDate: "  + localDate.toString());
        int day = localDate.getDayOfMonth();
        Month month = localDate.getMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return day == 4 && "JULY".equals(month.toString()) && ("SATURDAY".equals(dayOfWeek.toString()) || "SUNDAY".equals(dayOfWeek.toString()));
    }

    /**
     *  To check whether given date is July 4 and on Is on Weekend
     * @param localDate
     * @return
     */
    public static boolean isNextDayJuly4thOnSaturday(LocalDate localDate){

        LocalDate nextDay = localDate.plusDays(1);
        int day = nextDay.getDayOfMonth();
        Month month = nextDay.getMonth();
        DayOfWeek dayOfWeek = nextDay.getDayOfWeek();

        return day == 4 && "JULY".equals(month.toString()) && "SATURDAY".equals(dayOfWeek.toString());
    }


    public static boolean isPreviosDayJuly4thOnSunday(LocalDate localDate){
        LocalDate previousDay = localDate.minusDays(1);
        int day = previousDay.getDayOfMonth();
        Month month = previousDay.getMonth();
        DayOfWeek dayOfWeek = previousDay.getDayOfWeek();

        return day == 4 && "JULY".equals(month.toString()) && "SUNDAY".equals(dayOfWeek.toString());
    }
}
