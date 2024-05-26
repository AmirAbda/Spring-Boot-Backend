package com.amir.backend.exception;

public class ProductNotFound extends RuntimeException{

    public ProductNotFound(){

    }
    public ProductNotFound(String message){
        super(message);
    }
    
}
