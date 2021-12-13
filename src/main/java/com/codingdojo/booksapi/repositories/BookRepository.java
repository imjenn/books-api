package com.codingdojo.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.booksapi.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// Retrieves all from the db
	List<Book> findAll();
	// Finds books with descriptions containing search string
	List<Book> findByDescriptionContaining(String search);
	// Counts how many titles contain a certain string
//	Long countByTitleContaining(String search);
	// Deletes a book that starts with a specific title
//	Long deleteByTitleStartingWith(String search);
	
}
