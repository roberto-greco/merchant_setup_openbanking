package com.robertogreco.openbanking.exception;

public class MerchantAlreadyExistsException extends RuntimeException{

    private String message;
    public MerchantAlreadyExistsException(String message) {
        super(message);
        this.message=message;
    }

    public MerchantAlreadyExistsException() {
    }
}
