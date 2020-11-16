package com.capgemini.exception;

public class BookingNotFound extends RuntimeException{
    public BookingNotFound(String msg)
    {
        super(msg);
    }
}
