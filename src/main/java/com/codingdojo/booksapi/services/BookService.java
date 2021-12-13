package com.codingdojo.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// Create a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// Retrieves all books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// Retrieves one book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// Update 
	public Book updateBook(Long id, Book book) {
		
		if(bookRepository.findById(id).isPresent()) {
			Book b = bookRepository.findById(id).get();
			
			b.setTitle(book.getTitle());
			b.setDescription(book.getDescription());
			b.setLanguage(book.getLanguage());
			b.setNumberOfPages(book.getNumberOfPages());
			
			return bookRepository.save(b);
		} 
		return null;
	}
	
	
	// Delete a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
