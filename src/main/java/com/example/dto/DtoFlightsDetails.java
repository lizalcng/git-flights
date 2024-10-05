package com.example.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoFlightsDetails {
	@CsvBindByName(column = "flightNumber")
	private String flightNumber;
	@CsvBindByName(column = "airlineName")
	private String airlineName;
	@CsvBindByName(column = "departureAirport")
	private String departureAirport;
	@CsvBindByName(column = "departureDayStart")
	@CsvDate("MM/dd/yyyy")
	private LocalDate departureDayStart;
	@CsvBindByName(column = "departureDayEnd")
	@CsvDate("MM/dd/yyyy")
	private LocalDate departureDayEnd;
	@CsvBindByName(column = "departureTime")
	@CsvDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date departureTime;
	@CsvBindByName(column = "arrivalAirport")
	private String arrivalAirport;
	@CsvBindByName(column = "arrivalDay")
	private String arrivalDay;
	@CsvBindByName(column = "arrivalTime")
	@CsvDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date arrivalTime;
	@CsvBindByName(column = "duration")
	private Integer duration;
	@CsvBindByName(column = "totalSeats")
	private Integer totalSeats;
	@CsvBindByName(column = "availableSeats")
	private Integer availableSeats;
	@CsvBindByName(column = "price")
	private Integer price;
	@CsvBindByName(column = "flightStatus")
	private String flightStatus;
	@CsvBindByName(column = "aircraftType")
	private String aircraftType;
	@CsvBindByName(column = "Terminal")
	private String Terminal;
	@CsvBindByName(column = "GateNo")
	private Integer GateNo;
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
	public LocalDate getDepartureDayStart() {
		return departureDayStart;
	}
	public void setDepartureDayStart(LocalDate departureDayStart) {
		this.departureDayStart = departureDayStart;
	}
	public LocalDate getDepartureDayEnd() {
		return departureDayEnd;
	}
	public void setDepartureDayEnd(LocalDate departureDayEnd) {
		this.departureDayEnd = departureDayEnd;
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
	public String getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(String arrivalDay) {
		this.arrivalDay = arrivalDay;
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
