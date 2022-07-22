package com.francaemp.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francaemp.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail(String email);
	
}
