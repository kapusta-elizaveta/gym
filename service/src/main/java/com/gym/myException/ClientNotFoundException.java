package com.gym.myException;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message){
        super(message);
    }
}
