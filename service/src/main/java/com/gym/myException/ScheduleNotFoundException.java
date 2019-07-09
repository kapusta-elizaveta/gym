package com.gym.myException;

public class ScheduleNotFoundException extends RuntimeException{

    public ScheduleNotFoundException(String message){
        super(message);
    }
}
