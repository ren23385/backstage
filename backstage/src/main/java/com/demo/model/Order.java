package com.demo.model;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private double totallPrice;
	private int user_id;
	private int addressId;
	
	private String orderStatus;
	
	private String orderAddress;
	
	public Order() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTotallPrice() {
		return totallPrice;
	}
	public void setTotallPrice(double totallPrice) {
		this.totallPrice = totallPrice;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Order(double totallPrice, int user_id, String orderStatus) {
		super();
		this.totallPrice = totallPrice;
		this.user_id = user_id;
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totallPrice=" + totallPrice + ", user_id=" + user_id + ", orderStatus="
				+ orderStatus + "]";
	}	
	
	
}
