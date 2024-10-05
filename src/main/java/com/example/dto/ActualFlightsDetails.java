package com.example.dto;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class ActualFlightsDetails {

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date actualDepartureTime;
	private Date actualArrivalTime;
	private String flightNumber;
	private String departureAirport;
	private String departureDay;
	private String arrivalAirport;
	private String arrivalDay;
	
	public Date getActualDepartureTime() {
		return actualDepartureTime;
	}
	public void setActualDepartureTime(Date actualDepartureTime) {
		this.actualDepartureTime = actualDepartureTime;
	}
	public Date getActualArrivalTime() {
		return actualArrivalTime;
	}
	public void setActualArrivalTime(Date actualArrivalTime) {
		this.actualArrivalTime = actualArrivalTime;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public String getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(String arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	

}