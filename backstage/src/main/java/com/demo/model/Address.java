package com.demo.model;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private int mobile;
	private int telphone;
	private int user_id;
	private int code;
	public Address() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getTelphone() {
		return telphone;
	}
	public void setTelphone(int telphone) {
		this.telphone = telphone;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Address(String address, int mobile, int telphone, int user_id, int code) {
		super();
		this.address = address;
		this.mobile = mobile;
		this.telphone = telphone;
		this.user_id = user_id;
		this.code = code;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", mobile=" + mobile + ", telphone=" + telphone
				+ ", user_id=" + user_id + ", code=" + code + "]";
	}

}
