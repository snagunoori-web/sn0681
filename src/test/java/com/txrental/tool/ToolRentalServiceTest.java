package com.txrental.tool;

import com.txrental.tool.model.Checkout;
import com.txrental.tool.model.RentalAgreement;
import com.txrental.tool.service.ToolRentalService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//@ExtendWith(SpringExtension.class)
public class ToolRentalServiceTest {

    @Autowired
    private ToolRentalService toolRentalService;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Test
    public void testGenerateRentalAgreement(){
        String date = "07/02/2019"; // 2024 Labor Day
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        Checkout checkout = new Checkout("LADW" ,3, 10, localDate);
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);

        System.out.println(rentalAgreement.toString());

    }


}
