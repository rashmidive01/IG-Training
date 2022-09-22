package com.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagementSystem.Model.BookEntity;
import com.LibraryManagementSystem.Service.BookService;
import com.LibraryManagementSystem.Model.UserEntity;
import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.Repository.UserRepository;

import com.LibraryManagementSystem.Service.UserService;

public class BookController {
	@Autowired
	BookService bookService;
	
	//REST API
	//Save books for first time
	@PostMapping("/addBook/{id}")
	public BookEntity addBook(@RequestBody BookEntity bookEntity,@PathVariable Long id)
	{
		return bookService.addBook(bookEntity,id);
		
		}
//Update book
	@PutMapping("/editBook/{id}")
	public BookEntity editBook(@RequestBody BookEntity bookEntity,@PathVariable Long id)
	{
		bookEntity.setBookId(id);
		return bookService.editBook(bookEntity);
	
		
	}
	//Get All Book
	@GetMapping("/getAllBook")
	public List<BookEntity> getBook(){
		return (List<BookEntity>) bookService.findAllBooks();
	}
	////
	@GetMapping("/searchBookByName/name")
	public List<BookEntity> getBookByName(@RequestParam String name){
		return bookService.searchByName(name);
	}
	@GetMapping("/searchBookByAuthor/name")
	public ResponseEntity<List<BookEntity>> getBookByAuthor(@RequestParam String name){
		return bookService.searchByAuthor(name);
	}
	@GetMapping("/searchBookByPublication/name")
	public ResponseEntity<List<BookEntity>> getBookByPublication(@RequestParam String name){
		return bookService.searchByPublication(name);
	}

	@DeleteMapping("/deleteBookByName/{name}/{id}")
	public String deleteBook(@PathVariable String name, @PathVariable Long id) {
		bookService.deleteBook(name, id);
		return "Book deleted sucessfully!";
	}
}
