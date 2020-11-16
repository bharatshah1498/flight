package com.capgemini.exception;

public class ScheduleNotFound extends RuntimeException {
    public ScheduleNotFound(String msg)
    {
        super(msg);
    }
}
