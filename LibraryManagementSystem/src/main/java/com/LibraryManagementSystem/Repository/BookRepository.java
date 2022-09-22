package com.LibraryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LibraryManagementSystem.Model.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	List<BookEntity> findByBookName(String name);
	List<BookEntity> findByBookAuthor(String bookAuthor);
	List<BookEntity> findByBookPublication(String bookPublication);
	
}
