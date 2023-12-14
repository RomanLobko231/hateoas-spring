package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Entity
@Table(name = "books")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends RepresentationModel<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    @JsonProperty("title")
    private String title;
    @Column()
    @JsonProperty("description")
    private String description;
    @Column(nullable = false)
    @JsonProperty("isAvailableNow")
    private boolean isAvailableNow;
    @Column()
    @JsonProperty("userRating")
    private Integer userRating;

    public Book(String title, String description, boolean isAvailableNow, Integer userRating, Long id) {
        this.title = title;
        this.description = description;
        this.isAvailableNow = isAvailableNow;
        this.userRating = userRating;
        this.id = id;
    }

    protected Book(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailableNow() {
        return isAvailableNow;
    }

    public void setAvailableNow(boolean availableNow) {
        isAvailableNow = availableNow;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }
}
