# E-Commerce Backend

A backend e-commerce application built with **Spring Boot**, progressing from a basic REST API into a more production-oriented architecture involving persistence, containerization, monitoring, and microservices.

## Status

**In Progress**

The project is being developed incrementally, with the architecture and feature set evolving as new components are implemented.

## Overview

The application covers the core backend functionality of an e-commerce platform, including:

* User management
* Address management
* Product management
* Shopping cart functionality
* Order management
* RESTful API design
* Database persistence
* DTO-based architecture
* Application monitoring
* Docker containerization
* PostgreSQL integration
* Docker Compose
* Microservices architecture
* API Gateway concepts

The project starts as a structured monolithic Spring Boot application and progressively moves toward a distributed microservices architecture.

## Architecture

### Monolithic Application

The initial implementation follows a layered architecture:

```text
Client
  │
  ▼
Controller
  │
  ▼
Service
  │
  ▼
Repository
  │
  ▼
Database
```

### Microservices Architecture

The later architecture separates the application into independent services:

```text
                    ┌─────────────────┐
                    │    API Gateway  │
                    └────────┬────────┘
                             │
             ┌───────────────┼───────────────┐
             ▼               ▼               ▼
      ┌────────────┐  ┌────────────┐  ┌────────────┐
      │    User    │  │  Product   │  │   Order    │
      │  Service   │  │  Service   │  │  Service   │
      └────────────┘  └────────────┘  └────────────┘
             │               │               │
             ▼               ▼               ▼
          Database        Database        Database
```

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* REST APIs

### Database

* H2 — development/testing
* PostgreSQL — persistent database

### DevOps & Infrastructure

* Docker
* Docker Compose
* Docker Registry
* pgAdmin

### Monitoring

* Spring Boot Actuator
* Health checks
* Application metrics
* Logging
* Bean inspection

## Features

### User Management

* Fetch all users
* Create users
* Fetch individual users
* Update users
* Unique user identification
* User and address relationships
* DTO-based request/response handling

### Product Management

* Product entity
* Product CRUD operations
* Product API endpoints
* Product-related business logic

### Shopping Cart

* User-specific carts
* Add products to cart
* Remove products from cart
* Fetch cart contents
* Cart-related business logic

### Orders

* Order entity
* Order repository
* Order creation
* Place orders through an end-to-end API flow

## Project Structure

The project follows a layered and modular structure:

```text
src/
└── main/
    ├── java/
    │   └── ...
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── entity/
    │       ├── dto/
    │       └── ...
    │
    └── resources/
        └── application.properties
```

As the application transitions toward microservices, these components are separated into independently deployable services.

## REST API

The application exposes RESTful endpoints for its primary resources.

Example operations:

```text
GET     /api/users
POST    /api/users
GET     /api/users/{id}
PUT     /api/users/{id}

GET     /api/products
POST    /api/products
PUT     /api/products/{id}
DELETE  /api/products/{id}

GET     /api/cart/{userId}
POST    /api/cart/{userId}
DELETE  /api/cart/{userId}

POST    /api/orders
```

The exact endpoints may evolve as the architecture develops.

## Database

The project initially uses an in-memory **H2 database** for development and experimentation.

It later transitions to **PostgreSQL** for persistent storage.

Database interaction is handled through:

```text
Spring Data JPA
       │
       ▼
   Hibernate
       │
       ▼
  PostgreSQL
```

## DTO Architecture

The application uses **Data Transfer Objects (DTOs)** to separate API representations from persistence entities.

```text
HTTP Request
     │
     ▼
    DTO
     │
     ▼
 Service Layer
     │
     ▼
   Entity
     │
     ▼
 Repository
     │
     ▼
 Database
```

This helps maintain separation between the API layer and the database model.

## Monitoring

Spring Boot Actuator is used to expose operational information about the application.

Monitoring includes:

* Application health
* Application information
* Metrics
* Loggers
* Spring beans
* Application management endpoints

Example endpoints:

```text
/actuator/health
/actuator/info
/actuator/metrics
/actuator/loggers
/actuator/beans
```

## Docker

The application is containerized using Docker.

The project covers:

* Docker images
* Docker containers
* Dockerfiles
* Container lifecycle
* Docker networking
* Image management
* Running Spring Boot inside containers

Example workflow:

```text
Spring Boot Application
          │
          ▼
      Dockerfile
          │
          ▼
     Docker Image
          │
          ▼
     Docker Container
```

## Docker Compose

Docker Compose is used to manage multiple containers together.

A typical setup includes:

```text
┌─────────────────────┐
│ Spring Boot App     │
└──────────┬──────────┘
           │
           │ Docker Network
           │
┌──────────▼──────────┐
│ PostgreSQL          │
└─────────────────────┘
```

This allows the application and database to be started and managed as a single environment.

## Microservices

The project progressively moves from a monolithic architecture toward microservices.

The main services are:

```text
User Service
Product Service
Order Service
```

Each service is responsible for its own domain and can be developed and deployed independently.

### User Service

Responsible for:

* Users
* User-related data
* User operations

### Product Service

Responsible for:

* Products
* Product operations
* Product-related data

### Order Service

Responsible for:

* Orders
* Order creation
* Order-related operations

### API Gateway

An API Gateway provides a unified entry point for clients while routing requests to the appropriate microservice.

```text
             Client
                │
                ▼
          API Gateway
          /     |     \
         /      |      \
        ▼       ▼       ▼
      User   Product   Order
    Service  Service  Service
```

## Development Roadmap

* [x] Spring Boot project setup
* [x] Basic REST API structure
* [x] User CRUD operations
* [x] Service layer
* [x] ResponseEntity usage
* [ ] JPA & Hibernate integration
* [ ] H2 database integration
* [ ] Entity relationships
* [ ] DTO architecture
* [ ] Product APIs
* [ ] Shopping cart functionality
* [ ] Order functionality
* [ ] Spring Boot Actuator
* [ ] Docker fundamentals
* [ ] Spring Boot containerization
* [ ] PostgreSQL integration
* [ ] Docker networking
* [ ] Docker Compose
* [ ] Complete microservices migration
* [ ] User microservice
* [ ] Product microservice
* [ ] Order microservice
* [ ] API Gateway
* [ ] Complete microservices Docker Compose setup
* [ ] Integration testing
* [ ] Production-oriented improvements

## Running the Project

### Prerequisites

Install:

* Java JDK
* Maven
* Docker
* Docker Compose
* PostgreSQL (if running outside Docker)

### Clone

```bash
git clone <repository-url>
cd <project-directory>
```

### Run with Maven

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

### Build

```bash
./mvnw clean package
```

### Run with Docker

```bash
docker build -t ecommerce-backend .
docker run -p 8080:8080 ecommerce-backend
```

### Run with Docker Compose

```bash
docker compose up --build
```

## Learning Objectives

This project focuses on developing practical understanding of:

* RESTful API design
* Spring Boot architecture
* Controller-Service-Repository pattern
* Dependency Injection
* JPA and Hibernate
* Database persistence
* Entity relationships
* DTO design
* CRUD operations
* Application monitoring
* Docker fundamentals
* Container networking
* PostgreSQL
* Docker Compose
* Monolithic architecture
* Microservices architecture
* API Gateway design
* Service decomposition
* Scalable backend architecture

## Current Status

**Work in Progress**

The core e-commerce backend functionality is being implemented first, followed by infrastructure, containerization, and microservices-oriented architecture.

The repository will continue to evolve as additional services, infrastructure, testing, and production-oriented improvements are implemented.

## License

This project is intended for learning and development purposes.
