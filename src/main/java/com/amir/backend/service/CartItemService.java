package com.amir.backend.service;

import com.amir.backend.dto.CartDTO;
import com.amir.backend.model.CartItem;

public interface CartItemService {

    public CartItem createItemforCart(CartDTO cartdto);
    
    
}
