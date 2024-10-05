package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdminsToken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String token;
	
	@OneToOne(targetEntity = Admins.class,fetch = FetchType.EAGER)
	private Admins admins;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Admins getAdmins() {
		return admins;
	}
	public void setAdmins(Admins admins) {
		this.admins = admins;
	}
	
	

}
