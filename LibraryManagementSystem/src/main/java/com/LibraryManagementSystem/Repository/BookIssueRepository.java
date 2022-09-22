package com.LibraryManagementSystem.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagementSystem.Model.BookIssueEntity;

public interface BookIssueRepository extends JpaRepository<BookIssueEntity, Long> {
	   List<BookIssueEntity> findByissuedBy(Long userId);
	   List<BookIssueEntity> findBytransactionStatus(String transactionStatus);
}
