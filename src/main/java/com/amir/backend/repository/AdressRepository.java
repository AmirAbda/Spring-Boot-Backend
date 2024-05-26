package com.amir.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amir.backend.model.Address;

@Repository
public interface AdressRepository extends JpaRepository<Address , Integer> {

}
