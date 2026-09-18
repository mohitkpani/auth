# Assessment Authentication API

A Spring Boot REST API for user registration, login, JWT authentication, and role-based authorization.

## Features

- User Registration
- User Login
- BCrypt Password Encryption
- JWT Authentication
- JWT Token Validation
- Role-Based Authorization
- ADMIN and STUDENT Roles

## Technologies

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- MySQL
- Maven
- Postman

## APIs

### Register

**POST**

`/auth/register`

Registers a new user.

### Login

**POST**

`/auth/login`

Authenticates the user and returns a JWT token.

### Get Assessments

**GET**

`/assessments`

Access: **ADMIN, STUDENT**

### View Result

**GET**

`/assessments/result`

Access: **STUDENT**

### Create Assessment

**GET**

`/assessments/create`

Access: **ADMIN**

## JWT Authentication

For protected APIs, use:

`Authorization: Bearer <JWT_TOKEN>`

## Roles

**ADMIN**
- Access assessment creation
- Access assessments

**STUDENT**
- Access assessments
- View results

## Project Structure

```text
src/main/java/com/auth/assessment
│
├── config
│   ├── JwtAuthenticationFilter.java
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   └── AssessmentController.java
│
├── dto
│   ├── LoginRequestDTO.java
│   ├── LoginResponseDTO.java
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
    ├── CustomUserDetailsService.java
    └── JwtService.java
