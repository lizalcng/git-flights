package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightsDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String flightNumber;
	private String airlineName;
	private String departureAirport;
	private LocalDate departureDay;
	private Date departureTime;
	private Date actualDepartureTime;
	private String arrivalAirport;
	private String arrivalDay;
	private Date arrivalTime;
	private Date actualArrivalTime;
	private Integer duration;
	private Integer totalSeats;
	private Integer availableSeats;
	private Integer price;
	private String flightStatus;
	private String aircraftType;
	private String Terminal;
	private Integer GateNo;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public String getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	public LocalDate getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(LocalDate departureDay) {
		this.departureDay = departureDay;
	}
	public String getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(String arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
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
	public String getTerminal() {
		return Terminal;
	}
	public void setTerminal(String terminal) {
		Terminal = terminal;
	}
	public Integer getGateNo() {
		return GateNo;
	}
	public void setGateNo(Integer gateNo) {
		GateNo = gateNo;
	}
	
	
	
	
	

}
