package com.txrental.tool.service;


import com.txrental.tool.entity.Tool;
import com.txrental.tool.entity.ToolRental;
import com.txrental.tool.formatter.RentalFormatter;
import com.txrental.tool.model.Checkout;
import com.txrental.tool.model.RentalAgreement;
import com.txrental.tool.model.RentalAmount;
import com.txrental.tool.repository.ToolRentalRepository;
import com.txrental.tool.repository.ToolRepository;
import com.txrental.tool.util.RentalDateUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class ToolRentalService {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private ToolRentalRepository toolRentalRepository;

    private static final Logger log = LoggerFactory.getLogger(ToolRentalService.class);

    public List<Tool> listAllToools() {
        return toolRepository.findAll();
    }

    public Tool findToolByCode(String toolCode) {
        return toolRepository.findByToolCode(toolCode);
    }

    public ToolRental findToolRentalByToolType(String toolType) {
        return toolRentalRepository.findByToolType(toolType);
    }

    public RentalAgreement generateRentalAgreement(Checkout checkout){
        String toolCode = checkout.getToolCode();

        /*  Reading data from database */
        Tool toolDetails =  toolRepository.findByToolCode(toolCode);;
        ToolRental toolRental =  toolRentalRepository.findByToolType(toolDetails.getToolType());

         String toolType =  toolDetails.getToolType();
         String brand = toolDetails.getBrand();
         int rentingDays = checkout.getRentingDays();
         String discountPercentage =  RentalFormatter.percetageFormat(checkout.getDiscountPercentage());
         LocalDate checkOutDate = checkout.getCheckOutDate();
         double dailyCharge = toolRental.getDailyCharge();
         LocalDate dueDate = checkOutDate.plusDays(rentingDays);

         /* Calculating Rental Amount , Discount Percentage , Discount Amount, Final Charge*/
        RentalAmount rentalAmount = rentalCalculation(checkout,toolRental);
        int chargeDays = rentalAmount.getChargeDays();
        String preDiscountCharge =  RentalFormatter.numberFormatWithDollar(rentalAmount.getRentalAmount());
        double discountAmount=  calculateDiscountAmount(rentalAmount.getRentalAmount(), checkout.getDiscountPercentage());
        double finalCharge = rentalAmount.getRentalAmount() - discountAmount;

        /*   formatting   */
        String formattedDiscountAmt = RentalFormatter.numberFormatWithDollar(discountAmount);
        String formattedDailyCharge= RentalFormatter.numberFormatWithDollar(dailyCharge);
        String formattedFinalCharge = RentalFormatter.numberFormatWithDollar(finalCharge);


        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setToolCode(toolCode);
        rentalAgreement.setToolType(toolType);
        rentalAgreement.setBrand(brand);
        rentalAgreement.setRentalDays(rentingDays);
        rentalAgreement.setCheckOutDate(RentalFormatter.dateFormat(checkOutDate));
        rentalAgreement.setDueDate(RentalFormatter.dateFormat(dueDate) );
        rentalAgreement.setDailyRentalCharge(formattedDailyCharge);
        rentalAgreement.setChargeDays(chargeDays);
        rentalAgreement.setPreDiscountCharge(preDiscountCharge);
        rentalAgreement.setDiscountPercent(discountPercentage);
        rentalAgreement.setDiscountAmount(formattedDiscountAmt);
        rentalAgreement.setFinalCharge(formattedFinalCharge);

        log.info(rentalAgreement.toString());

      return rentalAgreement;
    }

    /**
     *  To calculate discount amount
     * @param amount
     * @param percentage
     * @return
     */
    public static double calculateDiscountAmount(double amount, double percentage) {
        return (amount * percentage) / 100;
    }


    /**
     *  To calculate rental amount by considering Weekday , Weekend and Holidays while calculating
     * @param checkout
     * @param toolRental
     * @return
     */
    private  RentalAmount rentalCalculation(Checkout checkout, ToolRental toolRental){

        double rentalAmount = 0;
        int chargeDays=0;

        LocalDate checkoutDate = checkout.getCheckOutDate();
        int noOfRentalDays = checkout.getRentingDays();
        double toolRentalChargePerDay =  toolRental.getDailyCharge();
        boolean isWeekendCharge = toolRental.getWeekendCharge().equalsIgnoreCase("Yes") ;
        boolean isHolidayCharge = toolRental.getHolidayCharge().equalsIgnoreCase("Yes") ;

        for(int i=1; i<=noOfRentalDays; i++){
            LocalDate date = checkoutDate.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            System.out.println(checkoutDate.plusDays(i) +"  "+ dayOfWeek);

            if(!isWeekendCharge &&  ("SATURDAY".equals(dayOfWeek.toString())  ||  "SUNDAY".equals(dayOfWeek.toString()))){
                continue;
            }
            if( !isHolidayCharge && ( RentalDateUtility.isLabourDay(date) ||  RentalDateUtility.isDayJuly4thAndWeekDay(date) || RentalDateUtility.isNextDayJuly4thOnSaturday(date) || RentalDateUtility.isPreviosDayJuly4thOnSunday(date))) {
                continue;
            }

            rentalAmount += toolRentalChargePerDay;
            chargeDays++;
            log.info("date "+ date + " dayOfWeek " + dayOfWeek + " rentalAmount " +"  "+ rentalAmount);


        }
       return new RentalAmount(rentalAmount, chargeDays);
    }
}
