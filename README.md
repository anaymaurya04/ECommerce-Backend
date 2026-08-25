# E-Commerce Backend

A backend e-commerce application built with **Spring Boot**, developed incrementally as a structured monolith — starting from plain in-memory REST APIs and progressing toward full database persistence, DTO-driven architecture, monitoring with Actuator, and beyond.

## Status

**In Progress** — User management is fully built out on top of a real persistence layer, and Product APIs are being expanded.

---

## Tech Stack

| Layer      | Technology                              |
|------------|------------------------------------------|
| Language   | Java 17                                  |
| Framework  | Spring Boot 4.1.0                        |
| Web        | Spring MVC (REST Controllers)            |
| Data       | Spring Data JPA + Hibernate              |
| Database   | H2 (in-memory, dev/testing)              |
| Boilerplate| Lombok                                   |
| Build      | Maven                                    |

## Architecture

The project follows a classic layered architecture:

```text
Client
  │
  ▼
Controller  (/api/users, /api/products)
  │
  ▼
Service     (business logic, DTO <-> Entity mapping)
  │
  ▼
Repository  (Spring Data JPA)
  │
  ▼
H2 Database (in-memory)
```

Requests enter through DTOs, are handled by the service layer, mapped to JPA entities, and persisted through Spring Data repositories.

## Implemented So Far

### User Management ✅

* REST API design: fetch all users, create new user
* Dedicated **User Service layer**
* Unique ID handling for users
* Fetch single user by ID (`Optional`-based responses)
* Proper HTTP semantics with `ResponseEntity` (200 / 201 / 404)
* Java **Streams** for data processing & response mapping
* Update User API (`PUT` endpoint)
* Class-level `@RequestMapping` route handling
* **JPA & Hibernate integration** with an H2 in-memory database
* Clean separation: Controller → Service → Repository (**DAL**)
* `User` entity with best practices: generated IDs, defaults, audit timestamps
* **User ↔ Address** one-to-one relationship (cascade + orphan removal)
* Full **DTO architecture** (`UserRequest`, `UserResponse`, `AddressDTO`) separating API payloads from entities
* Persistence via `UserRepository` (Spring Data JPA)

### Product Management 🚧

* `Product` entity designed for e-commerce (name, description, price as `BigDecimal`, quantity, category, image URL, active flag, audit timestamps)
* Persisted via `ProductRepository`
* Create product endpoint (`POST`)
* Update product endpoint (`PUT`)

## REST API

### Users

| Method | Endpoint           | Description                          |
|--------|--------------------|--------------------------------------|
| GET    | `/api/users`       | Fetch all users                      |
| GET    | `/api/users/{id}`  | Fetch single user                    |
| POST   | `/api/users`       | Create user                          |
| PUT    | `/api/users/{id}`  | Update user                          |

Example create/update payload:

```json
{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane@example.com",
  "phoneNo": "9876543210",
  "address": {
    "street": "123 Main St",
    "city": "Springfield",
    "state": "IL",
    "country": "USA",
    "zipcode": "62704"
  }
}
```

### Products

| Method | Endpoint                | Description          |
|--------|--------------------------|----------------------|
| POST   | `/api/products`         | Create product       |
| PUT    | `/api/products/{id}`    | Update product       |

Example payload:

```json
{
  "name": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799.00,
  "quantity": 50,
  "category": "Electronics",
  "image_url": "https://example.com/mouse.png"
}
```

## Project Structure

```text
src/main/java/com/ecom/app/
├── Controller/
│   ├── UserController.java
│   └── ProductController.java
├── Service/
│   ├── UserService.java
│   └── ProductService.java
├── Repository/
│   ├── UserRepository.java
│   └── ProductRepository.java
├── Model/
│   ├── User.java
│   ├── Address.java
│   ├── UserRole.java
│   └── Product.java
└── DTO/
    ├── UserRequest.java
    ├── UserResponse.java
    ├── AddressDTO.java
    ├── ProductRequest.java
    └── ProductResponse.java
```

## Database

Development runs on an **H2 in-memory database**:

```properties
spring.datasource.url=jdbc:h2:mem:test
spring.h2.console.enabled=true
```

H2 console is available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:test`) once the app is running.

## Running the Project

### Prerequisites

* Java JDK 17+
* Maven (or use the included wrapper)

### Run

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw spring-boot:run
```

The API is served at `http://localhost:8080`.

### Build

```bash
./mvnw clean package
```

## Roadmap

### Completed ✅

* [x] Design REST API: Fetch All Users
* [x] Design REST API: Create New User
* [x] Building User Service Layer
* [x] Challenge: Managing Unique IDs
* [x] Fetch Single User API
* [x] Using ResponseEntity in Spring Boot
* [x] Java Streams for Data Processing
* [x] Update User API (PUT Endpoint)
* [x] @RequestMapping Explained (Spring MVC)
* [x] Introduction to JPA & Hibernate
* [x] Understanding Data Access Layer (DAL)
* [x] H2 Database Setup (In-Memory DB)
* [x] Configuring JPA in Spring Boot
* [x] JPA Entities Explained (Best Practices)
* [x] Spring Data JPA Repositories
* [x] Persisting Data in Database
* [x] Testing API & Database Changes
* [x] Finalizing User Entity Model
* [x] Organizing Project Structure (Clean Code)
* [x] Entity Relationships: User & Address Mapping
* [x] DTO Pattern Explained (Why It Matters)
* [x] Migrating to DTO Architecture
* [x] Product Entity Design (Ecommerce)
* [x] Building Product APIs — create & update endpoints

### Up Next 🚀

#### Products

* [ ] Advanced Product APIs & Enhancements (remaining CRUD: fetch all, fetch by id, delete)

#### Shopping Cart

* [ ] Implementing User Cart System
* [ ] Add to Cart API (Business Logic)
* [ ] Remove from Cart API
* [ ] Fetch Cart API (User Session Handling)

#### Orders

* [ ] Order Entity & Repository Design
* [ ] Place Order API (End-to-End Flow)

#### Monitoring — Spring Boot Actuator

* [ ] Spring Boot Actuator Introduction (Monitoring)
* [ ] Setting Up Actuator in Project
* [ ] Enabling All Actuator Endpoints
* [ ] Exploring Actuator Endpoints
* [ ] Health Check Endpoint (`/health`)
* [ ] Info Endpoint (`/info`)
* [ ] Metrics Endpoint (`/metrics`)
* [ ] Logging & Debugging (`/loggers`)
* [ ] Beans Endpoint Explained (`/beans`)
* [ ] Shutdown Endpoint (`/shutdown`)
* [ ] Advanced Actuator Concepts

## Learning Objectives

This project focuses on developing practical understanding of:

* RESTful API design
* Spring Boot architecture & Spring MVC
* Controller–Service–Repository pattern
* Dependency Injection
* JPA, Hibernate & database persistence
* Entity relationships
* DTO design & request/response mapping
* Java Streams
* Application monitoring with Actuator
* Incremental, clean-code development practices

## Current Status

**Work in Progress**

Core user functionality is complete on top of a real persistence layer; product APIs, cart, orders, and observability features are being added step by step. This README is updated as each milestone lands.
