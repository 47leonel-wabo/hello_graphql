# Hello Spring Boot and GraphQL

Hello World project with Spring Boot 3.x and GraphQL on the same parent.

## Dependencies

* Spring Boot Starter GraphQl
* Spring Boot Starter Web
* Java Faker
* H2
* Spring Boot Starter Data JPA
* Java v17

## Note (⚠ important)

```markdown
GraphQL is independent of the dat layer !!
```

## Topics

* Query
* Pagination of the query

## Endpoints

* [REST](http://localhost:8080/api/v1/people?page=0&size=10)
* [GraphiQL](http://localhost:8080/graphiql?path=/graphql)

More structured page for graphql query
```graphql
{
  allPeoplePageBack(page: 0, size: 2) {
    totalPages
    totalElements
    isLast
    isFirst
    content {
      id
      firstName
      lastName
      email
      address {
        city
        state
      }
    }
  }
}
```

## Credit

me 🤭

🔥 Happy Coding