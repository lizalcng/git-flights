package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.opencsv.bean.CsvBindByName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatsCsv {
	
	@CsvBindByName(column = "seatNumber")
	private String seatNumber;
	@CsvBindByName(column = "seatClass")
    private String seatClass;
	@CsvBindByName(column = "isAvailable")
    private boolean isAvailable;
	@CsvBindByName(column = "price")
    private double price;
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public boolean getisAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
    
	
	
    

}
