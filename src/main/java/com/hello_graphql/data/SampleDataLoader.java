package com.hello_graphql.data;

import com.github.javafaker.Faker;
import com.hello_graphql.model.Address;
import com.hello_graphql.model.Person;
import com.hello_graphql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final PersonRepository mPersonRepository;
    private final Faker mFaker;

    public SampleDataLoader(PersonRepository personRepository) {
        mPersonRepository = personRepository;
        mFaker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> people = IntStream.rangeClosed(1, 100)
                .mapToObj(value -> new Person(
                        mFaker.name().firstName(),
                        mFaker.name().lastName(),
                        mFaker.phoneNumber().cellPhone(),
                        mFaker.internet().emailAddress(),
                        new Address(
                                mFaker.address().cityName(),
                                mFaker.address().state()
                        ))).collect(Collectors.toList());
        mPersonRepository.saveAll(people);
    }
}
