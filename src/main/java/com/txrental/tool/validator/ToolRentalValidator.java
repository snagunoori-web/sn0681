package com.txrental.tool.validator;

import com.txrental.tool.CustomToolRentalException;
import com.txrental.tool.model.Checkout;
import org.springframework.stereotype.Component;

@Component
public class ToolRentalValidator {

    public void validate(Checkout checkout) throws CustomToolRentalException {

        if ( checkout == null) {
            throw new CustomToolRentalException("Invalid Request");
        }

        if ( checkout.getRentingDays() < 1 ) {
            throw new CustomToolRentalException("Invalid Renting Days, it should be minimum 1 Day");
        }

    }

}
