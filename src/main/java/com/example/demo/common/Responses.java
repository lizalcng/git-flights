package com.example.demo.common;

public class Responses {
	
	private String message;
	private boolean bol;
	
	
	
	public Responses(String message, boolean bol) {
		this.message = message;
		this.bol = bol;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isBol() {
		return bol;
	}
	public void setBol(boolean bol) {
		this.bol = bol;
	}
	

}
