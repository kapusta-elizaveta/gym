package com.gym.myException;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(String message){
        super(message);
    }
}
