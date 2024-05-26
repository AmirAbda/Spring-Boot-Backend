package com.amir.backend.service;

import com.amir.backend.dto.CartDTO;
import com.amir.backend.exception.CartItemNotFound;
import com.amir.backend.exception.ProductNotFound;
import com.amir.backend.model.Cart;

public interface  CartService {

    Cart addProductToCart(CartDTO cart , String token) throws CartItemNotFound;

    Cart getCartProduct(String token);

    Cart removeProductFromCart(CartDTO cartDTO , String token) throws ProductNotFound;
    
}
