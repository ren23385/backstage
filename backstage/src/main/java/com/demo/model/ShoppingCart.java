package com.demo.model;

import java.io.Serializable;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String orderName;
	private double price;
	private int orderNumn;
	private double sumPrice;
	private int user_id;
	public ShoppingCart() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOrderNumn() {
		return orderNumn;
	}
	public void setOrderNumn(int orderNumn) {
		this.orderNumn = orderNumn;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public ShoppingCart(String orderName, double price, int orderNumn, double sumPrice, int user_id) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.orderNumn = orderNumn;
		this.sumPrice = sumPrice;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", orderName=" + orderName + ", price=" + price + ", orderNumn=" + orderNumn
				+ ", sumPrice=" + sumPrice + ", user_id=" + user_id + "]";
	}
	
	
}
