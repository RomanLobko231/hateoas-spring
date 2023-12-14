package com.example.demo.repository;

import com.example.demo.model.LibraryCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryCustomerRepository extends JpaRepository<LibraryCustomer, UUID> {

}
