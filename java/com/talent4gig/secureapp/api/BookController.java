package com.talent4gig.secureapp.api;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.talent4gig.secureapp.entity.Book;
import com.talent4gig.secureapp.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired private BookService bookService;
	
	@GetMapping
	@Transactional
	public List<Book> getAllBooks(){
		return bookService.findAll();
	}
	
	@GetMapping(value = "/{book_id}")
	@Transactional
	public Book getBook(@PathVariable("book_id") Long bookId) {
		Optional<Book> bookOpt = bookService.findBook(bookId);

		if (!bookOpt.isPresent()) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}

		return bookOpt.get();
	}
}
