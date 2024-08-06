package com.txrental.tool.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class RentalDateUtility {

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
