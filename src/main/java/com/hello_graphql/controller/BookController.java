package com.hello_graphql.controller;

import com.hello_graphql.model.Book;
import com.hello_graphql.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    private final BookRepository mBookRepository;

    public BookController(BookRepository bookRepository) {
        mBookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> allBooks() {
        return mBookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(final @Argument Long id) {
        return mBookRepository.findOne(id);
    }
}
