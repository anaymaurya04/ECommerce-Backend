# E-Commerce Backend

A backend e-commerce API built with **Spring Boot** and **H2**.

## Tech Stack

- Java 17, Spring Boot 4.1.0
- Spring Data JPA + Hibernate
- H2 in-memory database
- Lombok, Maven

## API Endpoints

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create user |
| PUT | `/api/users/{id}` | Update user |

### Products

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all active products |
| GET | `/api/products/search?keyword=` | Search products |
| POST | `/api/products` | Create product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product (soft) |

### Cart

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/cart` | Add to cart |
| GET | `/api/cart` | Get cart items |
| DELETE | `/api/cart/{productId}` | Remove from cart |

Cart endpoints require `X-User-ID` header.

### Orders

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Place order |
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get order by ID |

Order endpoints require `X-User-ID` header.

## Project Structure

```
src/main/java/com/ecom/app/
├── Controller/    → REST endpoints
├── Service/       → Business logic
├── Repository/    → Data access (Spring Data JPA)
├── Model/         → JPA entities
└── DTO/           → Request/response objects
```

## Running

```bash
./mvnw spring-boot:run
```

API at `http://localhost:8080`. H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:test`).
