package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ConfirmationToken {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String token;
	
	@OneToOne(targetEntity=TravellersInfo.class, fetch = FetchType.EAGER)
	private TravellersInfo travellers;

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

	public TravellersInfo getTravellers() {
		return travellers;
	}

	public void setTravellers(TravellersInfo travellers) {
		this.travellers = travellers;
	}
	
	
	

}
