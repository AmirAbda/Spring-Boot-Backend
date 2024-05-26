package com.amir.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir.backend.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByMobileNo(String mobileNo);

    Optional<Customer> findByEmailId(String emailId);

    Optional<Customer> findByMobileNoOrEmailId(String mobileNo, String emailId);
}