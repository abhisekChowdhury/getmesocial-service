package com.example.getmesocialservicedemo.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage() {
        return "Classified Information...";
    }
}
