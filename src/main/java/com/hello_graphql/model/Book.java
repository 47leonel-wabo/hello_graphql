package com.hello_graphql.model;

public record Book(Long id, String title, Integer pages, Author author, Rating rating) {
}
