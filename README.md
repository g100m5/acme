# Finance API

## Description

A simple REST API to work with users and their transactions.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL Database
- Gradle
- LiquedBase

## How to start the project

```sh
docker compose up -d
```

## API

- `POST /customers` - create a user
- `GET /customers/{id}` - get a user
- `PUT /customers/{id}` - update a user
- `POST /transactions` - create a transaction
- `GET /transactions` - get a list of transactions

## An Example

- `Create user:`:
```
curl --location 'http://127.0.0.1:8080/customers' \
--header 'Content-Type: application/json' \
--data '{
    "firstName": "John",
    "lastName": "Doe",
    "patronym": "",
    "email": "",
    "dob": "1980-10-10",
    "balance": 1000.00
}'
```


- `Create transaction:`:
```
'curl --location --request POST 'http://127.0.0.1:8080/transactions/9e4818a9-9d40-4bfe-a9f6-5a3676c98ff9?amount=111''
```
