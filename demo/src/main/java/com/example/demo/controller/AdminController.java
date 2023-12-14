package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.LibraryCustomer;
import com.example.demo.service.BookService;
import com.example.demo.service.LibraryCustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping("/admin-panel")
public class AdminController {

    private final BookService bookService;

    private final LibraryCustomerService customerService;

    public AdminController(BookService bookService, LibraryCustomerService customerService) {
        this.bookService = bookService;
        this.customerService = customerService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users")
    public List<LibraryCustomer> getAllCustomers(){
        return customerService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity<LibraryCustomer> saveLibraryCustomer(@RequestBody LibraryCustomer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
