package com.gym.myException;

public class OfficeNotFoundException extends RuntimeException {

    public OfficeNotFoundException(String message){
        super(message);
    }
}
