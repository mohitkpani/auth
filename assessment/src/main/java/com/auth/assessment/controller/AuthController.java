package com.auth.assessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.assessment.dto.LoginRequestDTO;
import com.auth.assessment.dto.LoginResponseDTO;
import com.auth.assessment.dto.RegisterRequestDTO;
import com.auth.assessment.service.AppUserService;
import com.auth.assessment.service.CustomUserDetailsService;
import com.auth.assessment.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    public AuthController(
            AppUserService appUserService,
            AuthenticationManager authenticationManager,
            CustomUserDetailsService customUserDetailsService,
            JwtService jwtService) {

        this.appUserService = appUserService;
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {

        String response = appUserService.register(registerRequestDTO);

        if (response.equals("User registered successfully.")) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.username(),
                        loginRequestDTO.password()
                )
        );

        UserDetails userDetails =
                customUserDetailsService.loadUserByUsername(
                        loginRequestDTO.username()
                );

        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(
                new LoginResponseDTO(token)
        );
    }
}