package com.example.crm.exception;

import lombok.Getter;

@SuppressWarnings(value = "serial")
@Getter
public class CustomerNotFoundException extends RuntimeException{
    private final int i18nId;
    private final String debugId;

    public CustomerNotFoundException (String message, int i18nId, String debugId){
        super(message);
        this.i18nId=i18nId;
        this.debugId=debugId;
    }

}
