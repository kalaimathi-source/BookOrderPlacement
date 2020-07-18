package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/api/books/{bookId}")
	public Book getBooksById(@PathVariable int bookId) {
		return service.getBooksById(bookId);
	}
	@RequestMapping(method = RequestMethod.PUT,value = "/api/updateBookStatus/{id}")
	public ResponseEntity<?> updateBookStatus(@PathVariable int id, @RequestBody Book book){
		if ("PLACE_ON_HOLD".equals(book.getStatus())) {
			String result = service.updateBookStatus(id);
			return ResponseEntity.ok().build(); 

		} else {
			return ResponseEntity.ok().build(); 
		}
	}
	@RequestMapping(method = RequestMethod.POST,value = "/api/storeBooks")
	public void storeBooks(@RequestBody Book book) {
		service.storeBooks(book);
	}
}



