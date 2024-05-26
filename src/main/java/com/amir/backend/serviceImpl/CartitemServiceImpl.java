package com.amir.backend.serviceImpl;
import org.springframework.stereotype.Service;

import com.amir.backend.dto.CartDTO;
import com.amir.backend.exception.ProductNotFoundException;
import com.amir.backend.model.CartItem;
import com.amir.backend.model.Product;
import com.amir.backend.model.ProductStatus;
import com.amir.backend.repository.ProductDao;
import com.amir.backend.service.CartItemService;


@Service
public class  CartitemServiceImpl  implements CartItemService{


    ProductDao productDao;

    public CartItem createItemforCart(CartDTO cartdto){
        Product existingProduct = productDao.findById(cartdto.getProductId()).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));

        if(existingProduct.getStatus().equals(ProductStatus.OUTOFSTOCK) || existingProduct.getQuantity()==0){
            throw new ProductNotFoundException("Product OUT of Stock");

        }

        CartItem newItem = new CartItem();

        newItem.setCartItemQuantity(1);

        newItem.setCartproduct(existingProduct);
        
        return newItem;
    }


    
}
