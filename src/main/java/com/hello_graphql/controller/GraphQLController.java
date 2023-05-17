package com.hello_graphql.controller;

import com.hello_graphql.model.Book;
import com.hello_graphql.model.Person;
import com.hello_graphql.repository.BookRepository;
import com.hello_graphql.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {
    private final BookRepository mBookRepository;
    private final PersonRepository mPersonRepository;

    public GraphQLController(BookRepository bookRepository, PersonRepository personRepository) {
        mBookRepository = bookRepository;
        mPersonRepository = personRepository;
    }

    @QueryMapping
    public List<Book> allBooks() {
        return mBookRepository.findAll();
    }

    @QueryMapping
    public Book findOne(final @Argument Long id) {
        return mBookRepository.findOne(id);
    }

    @QueryMapping
    public Iterable<Person> allPeople() {
        return mPersonRepository.findAll();
    }

    @QueryMapping
    public Page<Person> allPeoplePaged(final @Argument Integer page, final @Argument Integer size) {
        return mPersonRepository.findAll(PageRequest.of(page, size));
    }

    @QueryMapping
    public com.hello_graphql.model.Page allPeoplePageBack(final @Argument Integer page, final @Argument Integer size) {
        Page<Person> p = mPersonRepository.findAll(PageRequest.of(page, size));
        return new com.hello_graphql.model.Page(
                p.getTotalPages(),
                p.getNumberOfElements(),
                p.getContent(),
                p.isFirst(),
                p.isLast());

    }
}
