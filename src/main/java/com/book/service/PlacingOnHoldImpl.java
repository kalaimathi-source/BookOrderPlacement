package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service
public class PlacingOnHoldImpl implements PlacingOnHold{

	@Autowired
	BookRepository repository;

	@Override
	public Book getBooksById(int bookId) {
		return repository.findByBookId(bookId);
	}
	@Override
	public String updateBookStatus(int bookId) {
		Book bookbyId = repository.findByBookId(bookId);
		if(bookbyId==null) {
			return "BookNotFound";
		}
		else if(bookbyId.getStatus().equals("AVAILABLE")) {
			bookbyId.setStatus("PLACE_ON_HOLD");
			repository.save(bookbyId);
			return "BookPlacedOnHold";
		}else {
			return "BookConflictIdentified";
		}



	}
	public void storeBooks(Book book) {
		book.setStatus("AVAILABLE");
		repository.save(book);
	}
}