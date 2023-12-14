package com.example.demo.service;

import com.example.demo.errors.ContentDoesNotExistException;
import com.example.demo.errors.SortDoesNotExistException;
import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BooksRepository repository;

    public BookService(BooksRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ContentDoesNotExistException(id));
    }

    private List<Book> findAllAvailable() {
        return repository.findAll().stream().filter(Book::isAvailableNow).collect(Collectors.toList());
    }

    private List<Book> findByBestRating() {
        return repository.findAll(Sort.by("userRating").descending());
    }

    private List<Book> findByWorstRating() {
        return repository.findAll(Sort.by("userRating").ascending());
    }

    public List<Book> findAllOrSortedBooksBy(String sort) {
        return switch (sort) {
            case "available" -> findAllAvailable();
            case "ratingBest" -> findByBestRating();
            case "ratingWorst" -> findByWorstRating();
            case "" -> findAll();
            default -> throw new SortDoesNotExistException(sort);
        };
    }

    public void save(Book book) {
        repository.save(book);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
