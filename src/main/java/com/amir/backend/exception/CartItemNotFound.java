package com.amir.backend.exception;

public class CartItemNotFound extends RuntimeException {

    public CartItemNotFound(String message) {

        super(message);
    }

    public CartItemNotFound(){

    }


    
}
