package com.amir.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.backend.model.Seller;

public interface SellerDao extends JpaRepository<Seller , Integer> {

    Optional<Seller> findByMobile(String mobile);
    
}
