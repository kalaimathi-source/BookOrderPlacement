package com.book.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import com.book.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

	Book findByBookId(int bookId);
}
