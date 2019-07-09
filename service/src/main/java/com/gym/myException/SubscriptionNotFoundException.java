package com.gym.myException;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException(String message){
        super(message);
    }
}
