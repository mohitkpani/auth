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
