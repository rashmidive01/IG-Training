package com.LibraryManagementSystem.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="book_issue_table")
public class BookIssueEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long transactionId;
	
	private String transactionStatus;
	
	private String remarks;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookIssueDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date bookReturnDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date actualBookReturnDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date createdOn;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date modifiedOn;

	@ManyToOne
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private BookEntity book;
	
	@ManyToOne
	@JoinColumn(name = "issuedTo", referencedColumnName = "userId")
	private UserEntity issuedTo;
	
	@ManyToOne
	@JoinColumn(name = "issuedBy",referencedColumnName = "userId")
	private UserEntity issuedBy;
	
	@ManyToOne
	@JoinColumn(name = "createdBy",referencedColumnName = "userId")
	private UserEntity createdBy;
	
	
	@ManyToOne
	@JoinColumn(name = "modifiedBy", referencedColumnName = "userId")
	private UserEntity modifiedBy;
	
	public long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Date getBookIssueDate() {
		return bookIssueDate;
	}


	public void setBookIssueDate(Date bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}


	public Date getBookReturnDate() {
		return bookReturnDate;
	}


	public void setBookReturnDate(Date bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}


	public Date getActualBookReturnDate() {
		return actualBookReturnDate;
	}


	public void setActualBookReturnDate(Date actualBookReturnDate) {
		this.actualBookReturnDate = actualBookReturnDate;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}


	public BookEntity getBook() {
		return book;
	}


	public void setBook(BookEntity book) {
		this.book = book;
	}


	public UserEntity getIssuedTo() {
		return issuedTo;
	}


	public void setIssuedTo(UserEntity issuedTo) {
		this.issuedTo = issuedTo;
	}


	public UserEntity getIssuedBy() {
		return issuedBy;
	}


	public void setIssuedBy(UserEntity issuedBy) {
		this.issuedBy = issuedBy;
	}


	public UserEntity getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}


	public UserEntity getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(UserEntity modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	

}
