package com.amir.backend.service;

import java.util.List;

import com.amir.backend.dto.SellerDTO;
import com.amir.backend.dto.SessionDTO;
import com.amir.backend.exception.SellerException;
import com.amir.backend.model.Seller;

public interface SellerService {

    public Seller addSeller(Seller seller);

    public List<Seller> getSellers() throws SellerException;
    
    public Seller getSellerById(Integer sellerId) throws SellerException;

    public Seller getSellerByMobile(String mobile) throws SellerException;

    public Seller getCurrentlyLoggedInSeller(String token) throws SellerException;

    public SessionDTO updateSellerPassword(SellerDTO sellerDTO , String token) throws SellerException;
    

    
}
