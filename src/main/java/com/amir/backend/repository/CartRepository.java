package com.amir.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.backend.model.Cart;

public interface CartRepository extends JpaRepository<Cart , Integer> {

    
}
