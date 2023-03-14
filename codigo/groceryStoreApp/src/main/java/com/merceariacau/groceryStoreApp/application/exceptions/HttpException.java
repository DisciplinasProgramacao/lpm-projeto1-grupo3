package com.merceariacau.groceryStoreApp.application.exceptions;

public abstract class HttpException extends RuntimeException {
    protected final String message;

    protected HttpException(String message){
        super(message);
        this.message = message;
    }

}
