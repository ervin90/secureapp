package com.talent4gig.secureapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent4gig.secureapp.entity.Book;
import com.talent4gig.secureapp.repository.BookRepository;

@Service
public class BookService {

	@Autowired private BookRepository bookRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Optional<Book> findBook(Long bookId) {
		return bookRepository.findById(bookId);
	}

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
}
