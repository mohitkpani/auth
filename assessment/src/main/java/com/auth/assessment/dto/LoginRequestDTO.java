package com.auth.assessment.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
		
		@NotBlank(message = "Username can't be empty.")
		String username,
		
		@NotBlank(message = "Password can't be empty.")
		String password
		
		) {

}
