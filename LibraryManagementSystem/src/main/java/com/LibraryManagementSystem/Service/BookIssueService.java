package com.LibraryManagementSystem.Service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibraryManagementSystem.Model.BookEntity;
import com.LibraryManagementSystem.Model.BookIssueEntity;
import com.LibraryManagementSystem.Model.UserEntity;
import com.LibraryManagementSystem.Repository.BookIssueRepository;
import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.Repository.UserRepository;

@Service
public class BookIssueService {
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	private static final Logger log = LoggerFactory.getLogger(BookIssueEntity.class);
	

	public List<BookIssueEntity> getAllTransactions(){
		List<BookIssueEntity> bookIssue = new ArrayList<BookIssueEntity>();  
		bookIssueRepository.findAll().forEach(bookIssues -> bookIssue.add(bookIssues));  
		return bookIssue;
	}
	public BookIssueEntity createBookIssue(BookIssueEntity bookIssueEntity,Long bookId,Long userId,Long libId) {
		UserEntity userEntity = userRepository.findById(userId).get();
		UserEntity librId = userRepository.findById(libId).get();
		BookEntity bookEntity = bookRepository.findById(bookId).get();
		bookIssueEntity.setBook(bookEntity);
		bookIssueEntity.setIssuedTo(userEntity);
		bookIssueEntity.setIssuedBy(librId);
		bookIssueEntity.setCreatedBy(librId);
		bookIssueEntity.setModifiedBy(librId);
		return bookIssueRepository.save(bookIssueEntity);
	}
	
	public BookIssueEntity findTransactionByTransactionId(Long id){
		log.info("Book issued service called for finding transaction by id.");
		return bookIssueRepository.findById(id).orElse(null);
	}
	
	public List<BookIssueEntity> findTransactionByStatus(String name){	
		log.info("Book issued service called for finding transaction by name.");
		return bookIssueRepository.findBytransactionStatus(name);
	}
	

	public BookIssueEntity updateTransaction(BookIssueEntity bookIssuedTransaction) {
		log.info("Book issued service called for updating transaction.");
		BookIssueEntity existingProduct = bookIssueRepository.findById(bookIssuedTransaction.getTransactionId()).orElse(null);
		existingProduct.setActualBookReturnDate(bookIssuedTransaction.getActualBookReturnDate());
		existingProduct.setBookIssueDate(bookIssuedTransaction.getBookIssueDate());
		existingProduct.setBookReturnDate(bookIssuedTransaction.getBookReturnDate());
		existingProduct.setCreatedOn(bookIssuedTransaction.getCreatedOn());
		existingProduct.setIssuedBy(bookIssuedTransaction.getIssuedBy());
		existingProduct.setRemarks(bookIssuedTransaction.getRemarks());
		existingProduct.setTransactionStatus(bookIssuedTransaction.getTransactionStatus());
		existingProduct.setIssuedTo(bookIssuedTransaction.getIssuedTo());
		existingProduct.setBook(bookIssuedTransaction.getBook());
		existingProduct.setCreatedBy(bookIssuedTransaction.getCreatedBy());
		existingProduct.setModifiedBy(bookIssuedTransaction.getModifiedBy());
		existingProduct.setModifiedOn(bookIssuedTransaction.getModifiedOn());
		return bookIssueRepository.save(existingProduct);		
	}

}
