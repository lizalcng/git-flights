package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.FlightsDetails;
import com.example.demo.model.TravellersInfo;
import com.example.demo.service.FlightDetailsService;
import com.example.dto.ActualFlightsDetails;
import com.example.dto.ReturnFlightDto;

@RestController
@RequestMapping("/flights")
public class FlightDetailsController {
	
	@Autowired
	FlightDetailsService fds;
	
	@Autowired
	RestTemplate rt;
	
	
	@PostMapping("/addFlights")
	public ResponseEntity<String> addFlightsDetails(@RequestBody FlightsDetails flights){
		fds.addFlights(flights);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllFlights")
	public ResponseEntity<List<FlightsDetails>> getAllFlightsDetails(){
		return new ResponseEntity<>(fds.getAllFlights(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getOneWayFlights")
	public ResponseEntity<List<FlightsDetails>> getOneWayFlightsDetails(
	        @RequestParam("departureAirport") String departureAirport,
	        @RequestParam("departureDay") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDay,
	        @RequestParam("arrivalAirport") String arrivalAirport) {
	    
	    return new ResponseEntity<>(fds.findByDeparture(departureAirport, departureDay, arrivalAirport), HttpStatus.OK);
	}
	
	@GetMapping("/getRoundTripFlights")
	public ResponseEntity<ReturnFlightDto> getRoundTripFlightsDetails(@RequestParam("departureAirport") String departureAirport, @RequestParam("departureDay") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDay, @RequestParam("arrivalAirport") String arrivalAirport,@RequestParam("returnDay") LocalDate returnDay){

//		returns Arrays.asList(departureFlights, arrivalFlights);
		return new ResponseEntity<>(fds.findByRoundTripDeparture(departureAirport,departureDay,arrivalAirport,returnDay),HttpStatus.OK);
		
	}
	
//	@PostMapping("/postActualFlights")
//	public ResponseEntity<String> addActualFlights(@RequestBody ActualFlightsDetails afd){
//		flightservice.postActualFlights(afd);
//		URI path = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(afd.getId())
//				.toUri();
//		return ResponseEntity.created(path).build();
//		
//		
//		
//	}
	
	@PutMapping("/putActualFlightsDetails")
	public ResponseEntity<String> putActualFlights(@RequestBody ActualFlightsDetails afd){
		fds.putActualFlights(afd);

		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/postCsv", consumes= {"multipart/form-data"})
	public ResponseEntity<String> postSeats(@RequestPart("file") MultipartFile file) {
		try {
			fds.postCsv(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("success",HttpStatus.OK);
 
		
	}
	
//	@PostMapping("/confirmFlight")
//	public ResponseEntity <String> confirmFlight(@RequestParam("flightNumber") String flightNumber){
//		 fds.confirmFlight(flightNumber);
//		
//		return new ResponseEntity<>("success",HttpStatus.OK);
//	}
	
	
//	@GetMapping("/getActualFlightsDetails")
//	public ResponseEntity<ActualFlightsDetails> getActualFlights(){
//		ActualFlightsDetails actualFlightDetails = rt.postForObject("http://localhost:8080/flights/getActualFlightsDetails", fds, ActualFlightsDetails.class);
//		return new ResponseEntity<>(actualFlightDetails,HttpStatus.OK);
//		
//	}
	

	
	
	

}
