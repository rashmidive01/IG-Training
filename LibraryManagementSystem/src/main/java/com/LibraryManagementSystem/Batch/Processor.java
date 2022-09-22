package com.LibraryManagementSystem.Batch;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.LibraryManagementSystem.Model.BookEntity;
import com.LibraryManagementSystem.Model.UserEntity;
@Component
public class Processor implements ItemProcessor<BookEntity, BookEntity> {
	private UserEntity userEntity;
	public static final Logger log =  LoggerFactory.getLogger(ItemProcessor.class);
	
	@Override
	public BookEntity process(BookEntity bookEntity) throws Exception {
		log.info("Book Process start");
		bookEntity.setModifiedOn(new Date());
		bookEntity.setCreatedOn(new Date());
		bookEntity.setActiveFlag(1);
		log.info("--------------------"+bookEntity);
		log.info("Book Process stop");
		return bookEntity;
	}

}
