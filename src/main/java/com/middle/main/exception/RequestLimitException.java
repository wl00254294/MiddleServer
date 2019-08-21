package com.middle.main.exception;

public class RequestLimitException extends Exception{
    private static final long serialVersionUID = 1364225358754654702L;  

    public RequestLimitException() {  
        super("API Request number has Limtit");  
    }  

    public RequestLimitException(String message) {  
        super(message);  
    }  
}
