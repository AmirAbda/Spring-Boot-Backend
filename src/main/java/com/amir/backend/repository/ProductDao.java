package com.amir.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.backend.model.Product;

public interface ProductDao extends JpaRepository<Product , Integer>{

    
    
}
