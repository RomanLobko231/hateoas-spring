package com.example.demo.utils;

import com.example.demo.model.LibraryCustomer;
import com.example.demo.service.LibraryCustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AppicationRunner implements CommandLineRunner {

    private final LibraryCustomerService customerService;

    public AppicationRunner(LibraryCustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.save(new LibraryCustomer(
                "First Customer",
                List.of(40299292L, 8991947979L)
        ));
        customerService.save(new LibraryCustomer(
                "Second Customer",
                List.of(429040290900L)
        ));
    }
}
