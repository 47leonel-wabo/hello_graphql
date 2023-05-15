package com.hello_graphql.repository;

import com.hello_graphql.model.Book;
import com.hello_graphql.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> mBooks = new ArrayList<>();
    private final AuthorRepository mAuthorRepository;

    public BookRepository(AuthorRepository authorRepository) {
        mAuthorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return mBooks;
    }

    public Book findOne(final Long id) {
        return mBooks.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    @PostConstruct
    private void init() {
        mBooks.add(new Book(1L, "Reactive Spring", 484, mAuthorRepository.findByName("Josh Long"), Rating.FIVE_STARS));
        mBooks.add(new Book(2L, "Spring Boot Up & Running", 328, mAuthorRepository.findByName("Mark Mackler"), Rating.FIVE_STARS));
        mBooks.add(new Book(3L, "Hacking with Spring Boot 2.3", 484, mAuthorRepository.findByName("Grec Turnquist"), Rating.FIVE_STARS));
    }
}
