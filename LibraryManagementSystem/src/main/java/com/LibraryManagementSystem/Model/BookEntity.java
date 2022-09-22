package com.LibraryManagementSystem.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="BookTable")
public class BookEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long bookId;
	private String bookName;
    private String bookAuthor;
    private String bookPublication;
    private int numberOfPages;
    private double bookPrice;
    private int noOfCopies;
    private int activeFlag;
    
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date createdOn;
    
    
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date modifiedOn;
    
    @ManyToOne
    @JoinColumn(name = "createdBy", referencedColumnName = "userId")
    private UserEntity createdBy;

//
//	public long getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(long bookId) {
//		this.bookId = bookId;
//	}
//
//	public String getBookName() {
//		return bookName;
//	}
//
//	public void setBookName(String bookName) {
//		this.bookName = bookName;
//	}
//
//	public String getBookAuthor() {
//		return bookAuthor;
//	}
//
//	public void setBookAuthor(String bookAuthor) {
//		this.bookAuthor = bookAuthor;
//	}
//
//	public String getBookPublication() {
//		return bookPublication;
//	}
//
//	public void setBookPublication(String bookPublication) {
//		this.bookPublication = bookPublication;
//	}
//
//	public int getNumberOfPages() {
//		return numberOfPages;
//	}
//
//	public void setNumberOfPages(int numberOfPages) {
//		this.numberOfPages = numberOfPages;
//	}
//
//	public double getBookPrice() {
//		return bookPrice;
//	}
//
//	public void setBookPrice(double bookPrice) {
//		this.bookPrice = bookPrice;
//	}
//
//	public int getNoOfCopies() {
//		return noOfCopies;
//	}
//
//	public void setNoOfCopies(int noOfCopies) {
//		this.noOfCopies = noOfCopies;
//	}
//
//	public int getActiveFlag() {
//		return activeFlag;
//	}
//
//	public void setActiveFlag(int activeFlag) {
//		this.activeFlag = activeFlag;
//	}
//
//	public Date getCreatedOn() {
//		return createdOn;
//	}
//
//	public void setCreatedOn(Date createdOn) {
//		this.createdOn = createdOn;
//	}
//
//	public Date getModifiedOn() {
//		return modifiedOn;
//	}
//
//	public void setModifiedOn(Date modifiedOn) {
//		this.modifiedOn = modifiedOn;
//	}
//
//	public UserEntity getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(UserEntity createdBy) {
//		this.createdBy = createdBy;
//	}

	
}
