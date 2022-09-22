package com.LibraryManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.Model.BookEntity;
import com.LibraryManagementSystem.Model.UserEntity;
import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.Repository.UserRepository;

public class BookService {
@Autowired
BookRepository bookRepository;

@Autowired
UserRepository userRepository;

	public BookEntity addBook(BookEntity bookEntity,Long id)
	{
		return bookRepository.save(bookEntity);
	}
	public BookEntity editBook(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}
	public List<BookEntity> findAllBooks() {
		return bookRepository.findAll();
	}
	public List<BookEntity> getAllBooks()   
	{  
		List<BookEntity> books = new ArrayList<BookEntity>();  
		bookRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;
	}  
	
	
	public List<BookEntity> searchByName(String name){
		return bookRepository.findByBookName(name);
	}
	public ResponseEntity<List<BookEntity>> searchByAuthor(String name){
		return new ResponseEntity<List<BookEntity>>(bookRepository.findByBookAuthor(name),HttpStatus.OK);
	}
	public ResponseEntity<List<BookEntity>> searchByPublication(String name){
		return new ResponseEntity<List<BookEntity>>(bookRepository.findByBookPublication(name),HttpStatus.OK);
	}
	public BookEntity deleteBook(String name, Long id) {
		List<BookEntity> existingBook = bookRepository.findByBookName(name);
		UserEntity user = userRepository.findById(id).get();
		//existingBook.get(0).
		//existingBook.get(0).setNoOfCopies(0);
		//existingBook.get(0).setModifiedBy(user);
		return bookRepository.save(existingBook.get(0));
	}
	public BookEntity saveBook(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}
	public BookEntity saveBookInfo(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}
		
	}
	
