package com.talent4gig.secureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent4gig.secureapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	List<Role> findByEmail(String email);
}
