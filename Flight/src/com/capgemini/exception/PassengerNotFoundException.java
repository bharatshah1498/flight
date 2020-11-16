package com.capgemini.exception;

public class PassengerNotFoundException extends RuntimeException {
    public PassengerNotFoundException(String msg)
    {
        super(msg);
    }
}
