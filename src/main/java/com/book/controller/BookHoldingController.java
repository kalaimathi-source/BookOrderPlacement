package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.PlacingOnHold;

@RestController
class BookHoldingController {

	@Autowired
	PlacingOnHold service;

	/**
	 * Books displayed with status by Id.
	 */
	@RequestMapping("/api/books/{bookId}")
	public Book getBooksById(@PathVariable int bookId) {
		return service.getBooksById(bookId);
	}
	/**
	 * getBooks is used to display all the stored books.
	 */
	@RequestMapping("/api/books")
	public List<Book> getBooks() {
		return service.getAllBooks();
	}
	/**
	 * updateBookStatus is used to place order on books.
	 */
	@RequestMapping(method = RequestMethod.PUT,value = "/api/updateBookStatus")
	public ResponseEntity<?> updateBookStatus( @RequestBody Book book){
			String result = service.updateBookStatus(book);
			if(result.equals("BookPlacedOnHold")) {
				return ResponseEntity.ok().build(); 
			}else if(result.equals("BookNotFound")) {
				return ResponseEntity.notFound().build(); 
			}else {
	            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
			}
	}
	/**
	 * storeBooks is used to create books.
	 */
	@RequestMapping(method = RequestMethod.POST,value = "/api/storeBooks")
	public void storeBooks(@RequestBody Book book) {
		service.storeBooks(book);
	}
}



