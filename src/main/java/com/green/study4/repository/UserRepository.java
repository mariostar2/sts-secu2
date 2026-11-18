package com.green.study4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.study4.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User>findByUsername(String username);
	
}
