package com.txrental.tool.formatter;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *  This format will use to format dates , percentage and Number
 */
public class RentalFormatter {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    static NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * To format LocalDate to String
     * @param date
     * @return
     */
    public static String dateFormat(LocalDate date){
        return date.format(formatter);
    }

    /**
     *  To format given number with dollar preffix
     * @param amount
     * @return
     */
    public static String numberFormatWithDollar(double amount){
        return numberFormatter.format(amount);
    }

    /**
     *  To format given number with percentage suffix
     * @param amount
     * @return
     */
    public static String percetageFormat(double amount){
        return String.valueOf(amount) + "%";
    }
}
