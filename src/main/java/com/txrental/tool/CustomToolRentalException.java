package com.txrental.tool;

public class CustomToolRentalException extends Exception{

    public CustomToolRentalException(String message) {
        super(message);
    }

    public CustomToolRentalException(String message, Throwable cause) {
        super(message, cause);
    }

}
