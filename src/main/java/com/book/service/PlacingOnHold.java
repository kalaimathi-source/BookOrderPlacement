package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface PlacingOnHold {

	public List<Book> getAllBooks();
	
	public Book getBooksById(int bookId);
	
	public String updateBookStatus(Book book);
	
	public void storeBooks(Book book);

}
