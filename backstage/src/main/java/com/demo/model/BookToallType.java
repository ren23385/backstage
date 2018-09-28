package com.demo.model;

import java.io.Serializable;
import java.util.List;

public class BookToallType implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookType;
	
	private List<BookSingleType> singleTypes; 
	public BookToallType() {
		
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
	public BookToallType(String bookType) {
		super();
		this.bookType = bookType;
	}
	public List<BookSingleType> getSingleTypes() {
		return singleTypes;
	}
	public void setSingleTypes(List<BookSingleType> singleTypes) {
		this.singleTypes = singleTypes;
	}
	@Override
	public String toString() {
		return "BookToallType [id=" + id + ", bookType=" + bookType + ", singleTypes=" + singleTypes + "]";
	}
	
	
	
	
	

}
