package com.demo.model;

import java.io.Serializable;

public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;
	private String orderName;
	private double price;
	private double sumPrice;
	private int orderNum;
	private int order_id;
	public OrderItem() {
		
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
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public OrderItem(String orderName, double price, double sumPrice, int orderNum, int order_id) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.sumPrice = sumPrice;
		this.orderNum = orderNum;
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "OrderItem [orderName=" + orderName + ", price=" + price + ", sumPrice=" + sumPrice + ", orderNum="
				+ orderNum + ", order_id=" + order_id + "]";
	}
	
}
