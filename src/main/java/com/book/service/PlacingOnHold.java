package com.book.service;

import com.book.entity.Book;

public interface PlacingOnHold {

	public Book getBooksById(int bookId);
	
	public String updateBookStatus(Book book);
	
	public void storeBooks(Book book);

}
