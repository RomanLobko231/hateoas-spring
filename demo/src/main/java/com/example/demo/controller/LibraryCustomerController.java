package com.example.demo.controller;

import com.example.demo.model.LibraryCustomer;
import com.example.demo.service.LibraryCustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/my-profile")
public class LibraryCustomerController {

    private final LibraryCustomerService customerService;

    public LibraryCustomerController(LibraryCustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public LibraryCustomer getCustomerById(UUID id){
        return customerService.findById(id);
    }

    @GetMapping("/loaned-books")
    public List<Long> getLoanedBooksIdsByCustomerId(UUID id){
        return customerService.findById(id).getLoanedBooksIds();
    }
}
