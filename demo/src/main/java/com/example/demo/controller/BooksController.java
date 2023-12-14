package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.utils.BookModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/catalogue")
public class BooksController {

    private final BookService bookService;

    private final BookModelAssembler bookModelAssembler;

    public BooksController(BookService bookService, BookModelAssembler bookModelAssembler) {
        this.bookService = bookService;
        this.bookModelAssembler = bookModelAssembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Book> getBookById(@PathVariable Long id) {
        return bookModelAssembler.toModel(bookService.findById(id));
    }

    @GetMapping()
    public CollectionModel<EntityModel<Book>> getAllOrSortedBooks(
            @RequestParam(value = "sort", defaultValue = "") String sort) {
        List<EntityModel<Book>> books = bookService.findAllOrSortedBooksBy(sort)
                .stream()
                .map(bookModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(
                books,
                linkTo(methodOn(BooksController.class).getAllOrSortedBooks(sort)).withSelfRel()
                );
    }
}
