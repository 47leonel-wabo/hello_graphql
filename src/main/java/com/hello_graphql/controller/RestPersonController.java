package com.hello_graphql.controller;

import com.hello_graphql.model.Person;
import com.hello_graphql.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/v1/people"})
public class RestPersonController {
    private final PersonRepository mPersonRepository;

    public RestPersonController(PersonRepository personRepository) {
        mPersonRepository = personRepository;
    }

    @GetMapping
    public Page<Person> getAll(final @RequestParam(name = "page") Integer page, final @RequestParam(name = "size") Integer size) {
        return mPersonRepository.findAll(PageRequest.of(page, size));
    }
}
