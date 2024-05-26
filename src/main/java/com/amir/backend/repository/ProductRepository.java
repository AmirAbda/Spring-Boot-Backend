package com.amir.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amir.backend.model.CategoryEnum;
import com.amir.backend.model.Product;
import com.amir.backend.model.ProductStatus;
import com.amir.backend.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT new com.amir.backend.model.ProductDTO(p.productName, p.manufacturer, p.price, p.quantity) FROM Product p WHERE p.category = :catenum")
    List<ProductDTO> getAllProductsInACategory(@Param("catenum") CategoryEnum catenum);

    @Query("SELECT p FROM Product p WHERE p.status = :status")
    List<Product> getProductsWithStatus(@Param("status") ProductStatus status);

    @Query("SELECT p FROM Product p WHERE p.seller.id = :id")
    List<Product> getProductsOfASeller(@Param("id") Integer id);
}