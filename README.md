# Assessment Management System

A Spring Boot REST API project for user registration, authentication, and role-based authorization using Spring Security and MySQL.

## Features

- User Registration
- Password Encryption using BCrypt
- User Authentication
- Role-Based Authorization
- ADMIN and STUDENT roles
- Protected REST APIs
- MySQL Database Integration
- Input Validation

## Technologies

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Jakarta Validation

## Project Structure

```text
src/main/java/com/auth/assessment
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   └── AssessmentController.java
│
├── dto
│   └── RegisterRequestDTO.java
│
├── entity
│   └── AppUser.java
│
├── enums
│   └── Role.java
│
├── repository
│   └── AppUserRepository.java
│
└── service
    ├── AppUserService.java
    └── CustomerUserDetailsService.java
