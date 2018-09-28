package com.demo.model;

import java.io.Serializable;

public class Attributes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
