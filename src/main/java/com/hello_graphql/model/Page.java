package com.hello_graphql.model;

import java.util.List;

public record Page(Integer totalPages, Integer totalElements, List<Person> content, Boolean isFirst, Boolean isLast) {
}
