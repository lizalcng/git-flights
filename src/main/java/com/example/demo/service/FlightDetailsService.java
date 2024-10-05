package com.example.demo.service;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.FlightDetailsDao;
import com.example.demo.dao.TravellersInfoDao;
import com.example.demo.model.FlightsDetails;
import com.example.demo.model.Seats;
import com.example.demo.model.TravellersInfo;
import com.example.dto.ActualFlightsDetails;
import com.example.dto.DtoFlightsDetails;
import com.example.dto.ReturnFlightDto;
import com.example.dto.SeatsCsv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

@Service
public class FlightDetailsService {
	
	@Autowired
	FlightDetailsDao flightrepo;
	
	@Autowired
	TravellersInfoDao tid;
	
	
	
	public void addFlights(FlightsDetails fd) {
		flightrepo.save(fd);
	}

	public List<FlightsDetails> getAllFlights() {
		return flightrepo.findAll();
	}

	public List<FlightsDetails> findByDeparture(String departureAirport, LocalDate departureDay, String arrivalAirport) {
		
		return flightrepo.findByDeparture(departureAirport,departureDay, arrivalAirport);
	}
	
//	List<FlightsDetails>> departureFlights = fds.findByRoundTripDeparture();
//	List<FlightsDetails>> arrivalFlights = fds.findByRoundTripDeparture();
//	returnFlightDto.setFlight1(departureFlights);
//	returnFlightDto.setFlight2(arrivalFlights);

	public ReturnFlightDto findByRoundTripDeparture(String departureAirport, LocalDate departureDay, String arrivalAirport,
			LocalDate returnDay) {
		ReturnFlightDto r = new ReturnFlightDto();
		r.setFlight1(flightrepo.findByDeparture(departureAirport,departureDay, arrivalAirport));
		LocalDate departureDay2 = returnDay;
		String departureAirport2 = arrivalAirport;
		String arrivalAirport2 = departureAirport;
		r.setFlight2(flightrepo.findByDeparture(arrivalAirport,returnDay,departureAirport));
		return r;
		
	}
//
//	public void addActualFlights(ActualFlightsDetails afd) {
//		
//		FlightsDetails f = new FlightsDetails();
//		List<ActualFlightsDetails> proxy = actualrepo.findByActualDetails(f.getDepartureAirport(),f.getDepartureDay(), f.getArrivalAirport(), f.getFlightNumber());
//		for(int i=0;i<proxy.size();i++) {
//			
//		}
//		f.setActualArrivalTime(afd.getActualArrivalTime());
//		f.setActualDepartureTime(afd.getActualDepartureTime());
//	}
//	

	public void putActualFlights(ActualFlightsDetails afd) {
		FlightsDetails flights = new FlightsDetails();
		
		System.out.println(afd.getActualArrivalTime() + " " + afd.getActualDepartureTime());
		List<FlightsDetails> proxy = flightrepo.findByActualDetails(afd.getDepartureAirport(),afd.getDepartureDay(), afd.getArrivalAirport(), afd.getFlightNumber());
		System.out.println(proxy.get(0).getId());
		
		
		    for (FlightsDetails f : proxy) {
		        if (f.getFlightNumber().equals(afd.getFlightNumber())) {
		            f.setActualArrivalTime(afd.getActualArrivalTime());
		            f.setActualDepartureTime(afd.getActualDepartureTime());
		            flightrepo.save(f);
		        }
		    }
		}
	
	public void postCsv(MultipartFile file) throws IOException {
		List<FlightsDetails> fd = parseCsv(file);
	    if (fd != null && !fd.isEmpty()) {
	        flightrepo.saveAll(fd);
	    } else {
	        System.out.println("No valid data found in CSV to save.");
	    }
	}

//	public void postCsv(MultipartFile file) throws IOException {
//		Set<FlightsDetails> fd = parseCsv(file);
//		flightrepo.saveAll(fd);
//		
//	}
	
	private List<FlightsDetails> parseCsv(MultipartFile file) throws IOException {
        List<FlightsDetails> fds = new ArrayList<>();
	    try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	        HeaderColumnNameMappingStrategy<DtoFlightsDetails> strategy = new HeaderColumnNameMappingStrategy<>();
	        strategy.setType(DtoFlightsDetails.class);

	        CsvToBean<DtoFlightsDetails> csvToBean = new CsvToBeanBuilder<DtoFlightsDetails>(reader)
	                .withMappingStrategy(strategy)
	                .withIgnoreEmptyLine(true)
	                .withIgnoreLeadingWhiteSpace(true)
	                .build();

	        List<DtoFlightsDetails> csvData = csvToBean.parse();
	        
	        // Log CSV data to ensure it's parsed correctly
	        for (DtoFlightsDetails row : csvData) {	 
	        	LocalDate departureDayStart = row.getDepartureDayStart();
	        	LocalDate departureDayEnd = row.getDepartureDayEnd();
	        	while(departureDayEnd.isAfter(departureDayStart)) {
		            System.out.println("Parsed CSV Row - FlightNumber: " + row.getFlightNumber()+
		            ",AirlineName: " +row.getAirlineName()+
		            ",DepartureAirport: " +row.getDepartureAirport()+
		            " ,DepartureDayStart: " +row.getDepartureDayStart()+
		            " ,DepartureDayEnd: " +row.getDepartureDayEnd()+
		            " ,DepartureTime: " +row.getDepartureTime()+	     
		            ",ArrivalAirport: " +row.getArrivalAirport()+
		            ",ArrivalDay: " +row.getArrivalDay()+
		            ",ArrivalTime: " +row.getArrivalTime()+
		            ",Duration: " +row.getDuration()+
		            ",TotalSeats: " +row.getTotalSeats()+
		            ",AvailableSeats: " +row.getAvailableSeats()+
		            ",FlightStatus: " +row.getFlightStatus()+
		            ",AircraftType: " +row.getAircraftType()+
		            ",Terminal: " +row.getTerminal()+
		            ",GateNo: " +row.getGateNo() );
		            
                    FlightsDetails fd = new FlightsDetails();
                    fd.setFlightNumber(row.getFlightNumber());
                    fd.setAirlineName(row.getAirlineName());
                    fd.setDepartureAirport(row.getDepartureAirport());
                    fd.setDepartureDay(row.getDepartureDayStart());
                    fd.setDepartureTime(row.getDepartureTime());
//                    fd.setActualDepartureTime(null);
                    fd.setArrivalAirport(row.getArrivalAirport());
                    fd.setArrivalDay(row.getArrivalAirport());
                    fd.setArrivalTime(row.getArrivalTime());
//                    fd.setActualArrivalTime(null);
                    fd.setDuration(row.getDuration());
                    fd.setTotalSeats(row.getTotalSeats());
                    fd.setAvailableSeats(row.getAvailableSeats());
                    fd.setFlightStatus(row.getFlightStatus());
                    fd.setAircraftType(row.getAircraftType());
                    fd.setTerminal(row.getTerminal());
                    fd.setGateNo(row.getGateNo()); 
		             
                    fds.add(fd);
		            
		            departureDayStart = departureDayStart.plusDays(1);
	          
	        	}
	        	
	        }
//
//	        return csvData.stream()
//	                .map(csvRow -> {
//	                    FlightsDetails fd = new FlightsDetails();
//	                    fd.setFlightNumber(csvRow.getFlightNumber());
//	                    fd.setAirlineName(csvRow.getAirlineName());
//	                    fd.setDepartureAirport(csvRow.getDepartureAirport());
//	                    fd.setDepartureDay(csvRow.getDepartureDayStart());
//	                    fd.setDepartureTime(csvRow.getDepartureTime());
//	                    fd.setActualDepartureTime(null);
//	                    fd.setArrivalAirport(csvRow.getArrivalAirport());
//	                    fd.setArrivalDay(csvRow.getArrivalAirport());
//	                    fd.setArrivalTime(csvRow.getArrivalTime());
//	                    fd.setActualArrivalTime(null);
//	                    fd.setDuration(csvRow.getDuration());
//	                    fd.setTotalSeats(csvRow.getTotalSeats());
//	                    fd.setAvailableSeats(csvRow.getAvailableSeats());
//	                    fd.setFlightStatus(csvRow.getFlightStatus());
//	                    fd.setAircraftType(csvRow.getAircraftType());
//	                    fd.setTerminal(csvRow.getTerminal());
//	                    fd.setGateNo(csvRow.getGateNo());                    
//	                
//	                    return fd;
//	                })
//	                .collect(Collectors.toSet());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return fds;
	}

	public FlightsDetails confirmFlight(String flightNumber) {
		return flightrepo.findByFlightNumber(flightNumber);

//		TravellersInfo t = new TravellersInfo();
//		t.setFlightdetails(fd);
//		tid.save(t);
//		travelerRepo.save(t);
//		return t;
	}


//	FlightsDetails f = new FlightsDetails();
//	List<ActualFlightsDetails> proxy = flightrepo.findByActualDetails(f.getDepartureAirport(),f.getDepartureDay(), f.getArrivalAirport(), f.getFlightNumber());
//	for(int i=0;i<proxy.size();i++) {
//		if(afd.getFlightNumber()[i]==proxy[i]) {
//			f.setActualArrivalTime(afd.getActualArrivalTime());
//			f.setActualDepartureTime(afd.getActualDepartureTime());
//		}
//	}
//	

}

