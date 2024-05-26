package com.amir.backend.service;

import com.amir.backend.dto.CustomerDTO;
import com.amir.backend.dto.SellerDTO;
import com.amir.backend.dto.SessionDTO;
import com.amir.backend.model.UserSession;

public interface LoginLogoutService {

    UserSession loginCustomer(CustomerDTO customer);

    SessionDTO logoutCustomer(SessionDTO token);

    void deletExpiredTokens();

    UserSession loginSeller(SellerDTO seller);

    SessionDTO logoutSeller(SessionDTO session);

    
}
