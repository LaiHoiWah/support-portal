package com.meowu.support.client.commons.security.exception;

import com.meowu.commons.security.exception.MeowuException;

import java.text.MessageFormat;

public class TimeRegressionException extends MeowuException{

    public TimeRegressionException(){
        super();
    }

    public TimeRegressionException(String message){
        super(message);
    }

    public TimeRegressionException(Throwable cause){
        super(cause);
    }

    public TimeRegressionException(String message, Throwable cause){
        super(message, cause);
    }

    public TimeRegressionException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public TimeRegressionException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}
