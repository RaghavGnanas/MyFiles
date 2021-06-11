package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book)   {
		repository.insert(book);
		return "Added book with id :" + book.getId();
		
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Deleted the book with id: " + id;
	}
	
	@PutMapping(value = "/book/update")
	public String updateBook(@RequestBody Book book) {
		repository.save(book);
		return "The book is updated with id " +book.getId();
	}
	
	@DeleteMapping(value = "/book/deleteAll")
	public void deleteAllBooks() {
		repository.deleteAll();
		
		 System.out.println("All Books are Deleted");
	}
	
	
}



