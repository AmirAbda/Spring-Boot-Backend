package com.amir.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @PastOrPresent
    private LocalDate date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatusValues orderStatus;

    @NotNull
    private Double total;

    private String cardNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany
    private List<CartItem> ordercartItem = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
}