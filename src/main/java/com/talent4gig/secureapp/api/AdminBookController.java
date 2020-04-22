package com.talent4gig.secureapp.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talent4gig.secureapp.entity.Book;
import com.talent4gig.secureapp.service.BookService;

/**
 * 
 * A questa api si accede solo con ruolo ADMIN.
 * 
 * 
 * @author Ervin
 *
 */


@RestController
@RequestMapping(value = "/admin/books")
public class AdminBookController {
	
	@Autowired private BookService bookService;
	
	@PostMapping
	@Transactional
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@DeleteMapping("/{book_id}")
	@Transactional
	public String deleteBook(@PathVariable("book_id") Long bookId){
		bookService.deleteBook(bookId);
		return "Deleted!";
	}
}
