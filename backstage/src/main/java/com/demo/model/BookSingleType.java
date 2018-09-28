package com.demo.model;

import java.io.Serializable;

public class BookSingleType implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookType;
	private int bookToallType_id;
	
	public BookSingleType() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public int getBookToallType_id() {
		return bookToallType_id;
	}
	public void setBookToallType_id(int bookToallType_id) {
		this.bookToallType_id = bookToallType_id;
	}
	public BookSingleType(String bookType, int bookToallType_id) {
		super();
		this.bookType = bookType;
		this.bookToallType_id = bookToallType_id;
	}
	@Override
	public String toString() {
		return "BookSingleType [id=" + id + ", bookType=" + bookType + ", bookToallType_id=" + bookToallType_id + "]";
	}
	
	

}
