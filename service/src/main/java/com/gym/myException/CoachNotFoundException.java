package com.gym.myException;

public class CoachNotFoundException extends RuntimeException {

    public CoachNotFoundException(String message){
        super(message);
    }
}
