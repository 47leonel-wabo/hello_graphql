package com.hello_graphql.model;

public record Author(Long id, String firstName, String lastName) {
    public String fullName() {
        return firstName + " " + lastName;
    }
}
