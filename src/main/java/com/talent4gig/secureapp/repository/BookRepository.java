package com.talent4gig.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talent4gig.secureapp.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}	
