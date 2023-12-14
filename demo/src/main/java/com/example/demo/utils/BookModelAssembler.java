package com.example.demo.utils;

import com.example.demo.controller.BooksController;
import com.example.demo.model.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {
    @Override
    @NonNull
    public EntityModel<Book> toModel(Book entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(BooksController.class).getBookById(entity.getId())).withSelfRel(),
                linkTo(methodOn(BooksController.class).getAllOrSortedBooks("")).withRel("books")
                );
    }
}
