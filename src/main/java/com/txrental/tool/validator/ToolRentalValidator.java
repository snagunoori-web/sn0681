package com.txrental.tool.validator;

import com.txrental.tool.exception.CustomToolRentalException;
import com.txrental.tool.model.Checkout;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ToolRentalValidator {

    public void validate(Checkout checkout) throws CustomToolRentalException {

        if ( checkout == null) {
            throw new CustomToolRentalException("Invalid Request");
        }

        if(checkout.getDiscountPercentage() > 100 ||  checkout.getDiscountPercentage() < 0 ){
            throw new CustomToolRentalException("Invalid Discount Percentage, range should be in 0-100%");
        }

        if ( checkout.getRentingDays() < 1 ) {
            throw new CustomToolRentalException("Invalid Renting Days, it should be minimum 1 Day");
        }

        if ( checkout.getCheckOutDate() == null) {
            throw new CustomToolRentalException("Checkout date is missing");
        }

        if (StringUtils.isBlank(checkout.getToolCode() )) {
            throw new CustomToolRentalException("Checkout date is missing");
        }

    }

}
