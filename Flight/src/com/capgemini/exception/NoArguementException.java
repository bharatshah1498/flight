package com.capgemini.exception;

import org.omg.CORBA.NO_IMPLEMENT;

public class NoArguementException extends RuntimeException {
    public NoArguementException(String msg)
    {
        super(msg);
    }


}
