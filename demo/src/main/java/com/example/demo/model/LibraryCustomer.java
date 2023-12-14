package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class LibraryCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false)
    @JsonProperty("username")
    private String username;

    @Column(name = "loanedBooksIds")
    @JsonProperty("loanedBooksIds")
    private List<Long> loanedBooksIds;

    public LibraryCustomer(String username, List<Long> loanedBooksIds) {
        this.username = username;
        this.loanedBooksIds = loanedBooksIds;
    }

    protected LibraryCustomer(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getLoanedBooksIds() {
        return loanedBooksIds;
    }

    public void setLoanedBooksIds(List<Long> loanedBooksIds) {
        this.loanedBooksIds = loanedBooksIds;
    }
}
