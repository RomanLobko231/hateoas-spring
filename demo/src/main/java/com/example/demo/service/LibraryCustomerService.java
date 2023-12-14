package com.example.demo.service;

import com.example.demo.model.LibraryCustomer;
import com.example.demo.repository.LibraryCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibraryCustomerService {

    private final LibraryCustomerRepository repository;

    public LibraryCustomerService(LibraryCustomerRepository repository) {
        this.repository = repository;
    }

    public void save(LibraryCustomer customer){
        repository.save(customer);
    }

    public List<LibraryCustomer> findAll(){
        return repository.findAll();
    }

    public LibraryCustomer findById(UUID id){
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No such customer exists with id " + id));
    }
}
