package com.hello_graphql.repository;

import com.hello_graphql.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    private static final List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findByName(final String fullName) {
        return authors.stream()
                .filter(author -> author.fullName().equals(fullName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    public Author findById(final Long id) {
        return authors.stream()
                .filter(author -> author.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1L, "Josh", "Long"));
        authors.add(new Author(2L, "Mark", "Mackler"));
        authors.add(new Author(3L, "Grec", "Turnquist"));
    }
}
