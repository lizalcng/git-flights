package com.example.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.model.FlightsDetails;

public class ReturnFlightDto {

	
	private List<FlightsDetails> flight1;
	private List<FlightsDetails> flight2;
	public List<FlightsDetails> getFlight1() {
		return flight1;
	}
	public void setFlight1(List<FlightsDetails> list) {
		this.flight1 = list;
	}
	public List<FlightsDetails> getFlight2() {
		return flight2;
	}
	public void setFlight2(List<FlightsDetails> list) {
		this.flight2 = list;
	}
	
	

}
