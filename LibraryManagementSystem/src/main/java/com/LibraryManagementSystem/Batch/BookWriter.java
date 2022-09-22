package com.LibraryManagementSystem.Batch;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.Model.BookEntity;
@Configuration
public class BookWriter implements ItemWriter<BookEntity> {
	@Autowired
	private BookRepository bookRepository;

	private static final Logger log = LoggerFactory.getLogger(BookWriter.class);
	
	@Override
	public void write(List<? extends BookEntity> bookEntity) throws Exception {
		log.info("Data saved for :"+bookEntity);
		bookRepository.saveAll(bookEntity);
	}

}
