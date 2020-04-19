package com.talent4gig.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent4gig.secureapp.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);
	
}	
