package com.txrental.tool;

import com.txrental.tool.exception.CustomToolRentalException;
import com.txrental.tool.model.Checkout;
import com.txrental.tool.model.RentalAgreement;
import com.txrental.tool.service.ToolRentalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolRentalServiceTest {

    @Autowired
    private ToolRentalService toolRentalService;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");


    /**
     *   Test 1
     *   Excepting Exception for invalid input percentage - 101%
     */
    @Test
    public void testGenerateRentalAgreement_Jackhammer_Ridgid_Renting_3Days()  {

        LocalDate localDate = LocalDate.parse("09/03/15", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("JAKR" ,5, 101, localDate);

        /* Generate Agreement */
        try
        {
            RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
             Assert.assertNull(rentalAgreement);
        }catch (Exception e){
            Assert.assertTrue(true);
            Assert.assertTrue("Invalid Discount Percentage, range should be in 0-100%".equals(e.getMessage()));
        }

    }

    /**   Test 2
     *
     *             Tool          Daily Charge         Weekday Charge      Weekend charge      Holiday charge
     *             Ladder          $1.99                    Yes              Yes                    NO
     *
     *             Checkout Date : July 2, 2020 Thursday
     *
     *             July 2, 2020 Thursday
     *             July 3, 2020 Friday
     *             July 4, 2020 Saturday
     *
     *             *** Expected Agreement **
     *   Rental Days: 3
     *  CheckOut Date: 07/02/20
     *  Due Date: 07/05/20
     *  Daily Rental Charge: $1.99
     *  Charge Days: 2
     *  PreDiscount Charge: $3.98
     *  Discount Percent: 10.0%
     *  Discount Amount: $0.40
     *  Final Charge: $3.58
     *
     */
    @Test
    public void testGenerateRentalAgreement_Ladder_Renting_3Days() throws CustomToolRentalException {

        LocalDate localDate = LocalDate.parse("07/02/20", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("LADW" ,3, 10, localDate);

        /* Generate Agreement */
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
        Assert.assertNotNull(rentalAgreement);
        Assert.assertNotNull(rentalAgreement.getFinalCharge());
        Assert.assertEquals("$3.58",rentalAgreement.getFinalCharge());

        /* Print RentalAgreement*/
        System.out.println(rentalAgreement.toString());

    }


    /**     Test 3
     *
     *             Tool          Daily Charge         Weekday Charge      Weekend charge      Holiday charge
     *             Chainsaw          $1.49                    Yes              No                    Yes
     *
     *             Checkout Date : July 2, 2015 Thursday
     *
     *   July 2, 2015 Thursday    Charge
     *   July 3, 2015 Friday,     Charge
     *   July 4, 2015 Saturday,   Holiday & Weekend No charge
     *   July 5, 2015 Sunday,     Weekend No charge
     *   July 6, 2015 Monday,     Charge
     *   July 7, 2015 Tuesday     Charge
     *
     *
     *  Rental Days: 5
     *  CheckOut Date: 07/02/15
     *  Due Date: 07/07/15
     *  Daily Rental Charge: $1.49
     *  Charge Days: 3
     *  PreDiscount Charge: $4.47
     *  Discount Percent: 25.0%
     *  Discount Amount: $1.12
     *  Final Charge: $3.35

     *
     */
    @Test
    public void testGenerateRentalAgreement_Chainsaw_Renting_5Days() throws CustomToolRentalException {

        LocalDate localDate = LocalDate.parse("07/02/15", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("CHNS" ,5, 25, localDate);

        /* Generate Agreement */
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
        Assert.assertNotNull(rentalAgreement);
        Assert.assertNotNull(rentalAgreement.getFinalCharge());
       Assert.assertEquals("$3.35",rentalAgreement.getFinalCharge());

        /* Print RentalAgreement*/
        System.out.println(rentalAgreement.toString());

    }

    /**     Test   4
     *
     *    *             Tool          Daily Charge         Weekday Charge      Weekend charge      Holiday charge
     *      *             JAKD          $2.99                    Yes              No                    No
     *      *
     *      *             Checkout Date : Sep 3, 2015 Thursday
     *
     *   Checkout Date : Sep 3, 2015 Thursday    -  Charge
     *   Checkout Date : Sep 4, 2015 Friday    -  Charge
     *   Checkout Date : Sep 5, 2015 Saturday   No Charge
     *   Checkout Date : Sep 6, 2015 Sunday     No Charge
     *   Checkout Date : Sep 7, 2015 Monday    -  Holiday --- No Charge
     *   Checkout Date : Sep 8, 2015 Tuesday   -  Charge
     *   Checkout Date : Sep 9, 2015 Wednesday  -  Charge
     *
     *  Rental Days: 6
     *  CheckOut Date: 09/03/15
     *  Due Date: 09/09/15
     *  Daily Rental Charge: $2.99
     *  Charge Days: 3
     *  PreDiscount Charge: $8.97
     *  Discount Percent: 0.0%
     *  Discount Amount: $0.00
     *  Final Charge: $8.97
     *
     */
    @Test
    public void testGenerateRentalAgreement_Jackhammer_DeWalt_Renting_6Days() throws CustomToolRentalException {

        LocalDate localDate = LocalDate.parse("09/03/15", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("JAKD" ,6, 0, localDate);

        /* Generate Agreement */
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
        Assert.assertNotNull(rentalAgreement);
        Assert.assertNotNull(rentalAgreement.getFinalCharge());
        Assert.assertEquals("$8.97",rentalAgreement.getFinalCharge());

        /* Print RentalAgreement*/
        System.out.println(rentalAgreement.toString());

    }


    /**       Test 5
     *
     *             Tool          Daily Charge         Weekday Charge      Weekend charge      Holiday charge
     *             Chainsaw          $2.99                    Yes              No                    No
     *
     *             Checkout Date : July 2, 2015 Thursday
     *
     *
     *          July 2, 2015 Thursday    Charge
     *      *   July 3, 2015 Friday,     No charge ----  July 4 on Saturday
     *      *   July 4, 2015 Saturday,   Holiday & Weekend No charge
     *      *   July 5, 2015 Sunday,     Weekend No charge
     *      *   July 6, 2015 Monday,     Charge
     *      *   July 7, 2015 Tuesday     Charge
     *          July 8, 2015 Wednesday   Charge
     *          July 9, 2015 Thursday    Charge
     *          July 10, 2015 Friday     Charge
     *
     *
     *  Rental Days: 9
     *  CheckOut Date: 07/02/15
     *  Due Date: 07/11/15
     *  Daily Rental Charge: $2.99
     *  Charge Days: 6
     *  PreDiscount Charge: $17.94
     *  Discount Percent: 0.0%
     *  Discount Amount: $0.00
     *  Final Charge: $17.94
     *
     */

    @Test
    public void testGenerateRentalAgreement_Jackhammer_Ridgid_Renting_9Days() throws CustomToolRentalException {

        LocalDate localDate = LocalDate.parse("07/02/15", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("JAKR" ,9, 0, localDate);

        /* Generate Agreement */
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
        Assert.assertNotNull(rentalAgreement);
        Assert.assertNotNull(rentalAgreement.getFinalCharge());
        Assert.assertEquals("$17.94",rentalAgreement.getFinalCharge());

        /* Print RentalAgreement*/
        System.out.println(rentalAgreement.toString());

    }


    /**
     *     Test 6
     *
     *             Tool          Daily Charge         Weekday Charge      Weekend charge      Holiday charge
     *             Chainsaw          $2.99                    Yes              No                    No
     *
     *             Checkout Date : July 2, 2020 Thursday
     *
     *             July 2, 2020 Thursday     Charge
     *             July 3, 2020 Friday       No Charge
     *             July 4, 2020 Saturday     No Charge
     *             July 5, 2020 Sunday       No Charge
     *
     *
     *   Rental Days: 4
     *  CheckOut Date: 07/02/20
     *  Due Date: 07/06/20
     *  Daily Rental Charge: $2.99
     *  Charge Days: 1
     *  PreDiscount Charge: $2.99
     *  Discount Percent: 50.0%
     *  Discount Amount: $1.50
     *  Final Charge: $1.50
     *
     *  ---------------------------------------------
     *
     *
     */
    @Test
    public void testGenerateRentalAgreement_Jackhammer_Ridgid_Renting_4Days() throws CustomToolRentalException {

        LocalDate localDate = LocalDate.parse("07/02/20", formatter); // MM/dd/yy
        Checkout checkout = new Checkout("JAKR" ,4, 50, localDate);

        /* Generate Agreement */
        RentalAgreement rentalAgreement = toolRentalService.generateRentalAgreement(checkout);
        Assert.assertNotNull(rentalAgreement);
        Assert.assertNotNull(rentalAgreement.getFinalCharge());
        Assert.assertEquals("$1.50",rentalAgreement.getFinalCharge());

        /* Print RentalAgreement*/
        System.out.println(rentalAgreement.toString());

    }


}
