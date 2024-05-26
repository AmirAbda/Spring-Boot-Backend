package com.amir.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String productName;
    private String manufacturer;
    private Double price;
    private Integer quantity;
    
}