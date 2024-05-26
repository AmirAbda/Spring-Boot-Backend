package com.amir.backend.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItem = new ArrayList<>();

    private Double cartTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Customer customer;
}
