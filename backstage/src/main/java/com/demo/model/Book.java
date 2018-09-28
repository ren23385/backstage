package com.demo.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookName;
	private String author;
	private String bookConcern;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	private int page;
	private double oldPrice;
	private double newPrice;
	private double prixPrice;
	private int bookToallType_id;
	private int bookSingleType_id;
	private String descri;
	private String photo;
	
	public Book() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookConcern() {
		return bookConcern;
	}
	public void setBookConcern(String bookConcern) {
		this.bookConcern = bookConcern;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}
	public double getPrixPrice() {
		return prixPrice;
	}
	public void setPrixPrice(double prixPrice) {
		this.prixPrice = prixPrice;
	}
	public int getBookToallType_id() {
		return bookToallType_id;
	}
	public void setBookToallType_id(int bookToallType_id) {
		this.bookToallType_id = bookToallType_id;
	}
	public int getBookSingleType_id() {
		return bookSingleType_id;
	}
	public void setBookSingleType_id(int bookSingleType_id) {
		this.bookSingleType_id = bookSingleType_id;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Book(String bookName, String author, String bookConcern, Date publishDate, int page, double oldPrice,
			double newPrice, double prixPrice, int bookToallType_id, int bookSingleType_id, String descri,
			String photo) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookConcern = bookConcern;
		this.publishDate = publishDate;
		this.page = page;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.prixPrice = prixPrice;
		this.bookToallType_id = bookToallType_id;
		this.bookSingleType_id = bookSingleType_id;
		this.descri = descri;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", bookConcern=" + bookConcern
				+ ", publishDate=" + publishDate + ", page=" + page + ", oldPrice=" + oldPrice + ", newPrice="
				+ newPrice + ", prixPrice=" + prixPrice + ", bookToallType_id=" + bookToallType_id
				+ ", bookSingleType_id=" + bookSingleType_id + ", descri=" + descri + ", photo=" + photo + "]";
	}
	
	
	
}
