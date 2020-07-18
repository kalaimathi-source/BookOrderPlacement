package com.book.service;

import com.book.entity.Book;

public interface PlacingOnHold {

	public Book getBooksById(int bookId);
	
	public String updateBookStatus(
			int bookId);
	
	public void storeBooks(
			Book book);
}
