package com.amir.backend.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amir.backend.dto.SellerDTO;
import com.amir.backend.dto.SessionDTO;
import com.amir.backend.exception.LoginException;
import com.amir.backend.exception.SellerException;
import com.amir.backend.model.Seller;
import com.amir.backend.model.UserSession;
import com.amir.backend.repository.SellerDao;
import com.amir.backend.repository.SellerRepository;
import com.amir.backend.service.LoginLogoutService;

@Service
public class SellerServiceImpl {
    @Autowired
	private SellerDao sellerDao;

    @Autowired
    private LoginLogoutService loginService;

    public Seller addSeller(Seller seller) {
        return sellerDao.save(seller);
    }

    public List<Seller> getSellers() throws SellerException {
        List<Seller> sellers = sellerDao.findAll();
        if (sellers.isEmpty()) {
            throw new SellerException("No seller found");
        }
        return sellers;
    }

    public Seller getCurrentlyLoggedInSeller(String token) throws SellerException {
        if (!token.contains("seller")) {
            throw new SellerException("Invalid session token for seller");
        }

        loginService.checkTokenStatus(token);

        Optional<UserSession> userSessionOptional = sellerDao.findByToken(token);
        if (!userSessionOptional.isPresent()) {
            throw new SellerException("User session not found for the given token");
        }

        UserSession userSession = userSessionOptional.get();
        Seller existingSeller = sellerDao.findById(userSession.getUserId())
                .orElseThrow(() -> new SellerException("Seller not found for this ID"));

        return existingSeller;
    }

    public SessionDTO updateSellerPassword(SellerDTO sellerDTO, String token) {
        if (!token.contains("seller")) {
            throw new LoginException("Invalid session token for seller");
        }
        loginService.checkTokenStatus(token);

        UserSession user = sessionDao.findByToken(token).get();

        Optional<Seller> opt = sellerDao.findById(user.getUserId());

        if (opt.isEmpty())
            throw new SellerException("Seller does not exist");

        Seller existingSeller = opt.get();

        if (!sellerDTO.getMobile().equals(existingSeller.getMobile())) {
            throw new SellerException("Mobile number does not match");
        }

        existingSeller.setPassword(sellerDTO.getPassword());

        sellerDao.save(existingSeller);
        sellerDao.save(existingSeller);

        SessionDTO session = new SessionDTO();
        session.setToken(token);
        loginService.logoutSeller(session);
        session.setMessage("Updated password and logged out. Login again with new password");

        return session;
    }
}