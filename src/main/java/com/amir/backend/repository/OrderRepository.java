package com.amir.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amir.backend.model.Customer;
import com.amir.backend.model.Order;

public interface  OrderRepository extends JpaRepository<Order , Integer> {

    public List<Order> findByDate (LocalDate date);

    @Query("select c from Customer c where c.customerId = customerId")
    public Customer getCustomerByOrderid(@Param("customerId") Integer customerId);
    
}
  