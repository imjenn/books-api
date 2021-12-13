package com.codingdojo.booksapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.services.BookService;

@Controller
public class BookController {
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@Autowired 
	BookService bookService;
	
	// Create new book - display route
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	// Create new book - action route
	@PostMapping(value="/books") 
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	// Retrieve all books
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	// Retrieve one book
	@GetMapping("/books/{bookId}")
	public String show(Model model, @PathVariable("bookId") Long bookId) {
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	public String update(@Valid @PathVariable("id") Long id, @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(id, book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping(value="/books/{id}/delete", method=RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
}
