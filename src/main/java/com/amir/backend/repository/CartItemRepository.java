package com.amir.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.backend.model.CartItem;

public interface CartItemRepository  extends JpaRepository<CartItem, Integer> {


}
