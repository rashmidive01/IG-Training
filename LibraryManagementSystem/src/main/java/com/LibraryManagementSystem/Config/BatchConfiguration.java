package com.LibraryManagementSystem.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.LibraryManagementSystem.Model.BookEntity;
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Bean
	Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<BookEntity> itemReader, ItemProcessor<BookEntity, BookEntity> itemProcessor, ItemWriter<BookEntity> itemWriter) {
		log.info("BookBatchOperationConfiguration-job()-started");
		Step step = stepBuilderFactory.get("ETL-File-Load")
				.<BookEntity,BookEntity>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		log.info("BookBatchOperationConfiguration-job()-ended");
		return jobBuilderFactory.get("ETL-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
		
	}

	@Bean
	FlatFileItemReader<BookEntity> itemReader(@Value("${input}") Resource resource){
		log.info("BookBatchOperationConfiguration-itemReader()");
		FlatFileItemReader<BookEntity> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(0);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	LineMapper<BookEntity> lineMapper() {
		log.info("BookBatchOperationConfiguration-lineMapper()");
		DefaultLineMapper<BookEntity> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"bookAuthor","bookName","bookPrice","bookPublication","noOfCopies","numberOfPages"});
		
		BeanWrapperFieldSetMapper<BookEntity> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(BookEntity.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
