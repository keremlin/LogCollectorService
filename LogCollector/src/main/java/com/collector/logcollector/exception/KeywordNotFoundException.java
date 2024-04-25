package com.collector.logcollector.exception;

public class KeywordNotFoundException extends RuntimeException{
    public KeywordNotFoundException(){}
    public KeywordNotFoundException(String message){
        super(message);
    }
}
