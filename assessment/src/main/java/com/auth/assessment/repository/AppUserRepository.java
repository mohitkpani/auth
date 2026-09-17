package com.auth.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.assessment.entity.AppUser;

public interface AppUserRepository
		extends JpaRepository<AppUser, Long> {
	
	boolean existsByUsername(String username);
	
	boolean existsByEmail(String email);
	
	Optional<AppUser> findByUsername(String username);
}
