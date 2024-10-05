package com.example.demo.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FlightsDetails;
import com.example.dto.ActualFlightsDetails;

@Repository
public interface FlightDetailsDao extends JpaRepository<FlightsDetails,Integer>{

	@Query("from FlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3")
	List<FlightsDetails> findByDeparture(String departureAirport, LocalDate departureDay, String arrivalAirport);

	@Query("from FlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3 and flightNumber=?4")
	List<FlightsDetails> findByActualDetails(String departureAirport, String departureDay, String arrivalAirport,
			String flightNumber);

	@Query("from FlightsDetails where flightNumber=?1")
	FlightsDetails findByFlightNumber(String flightNumber);


		
//	@Query("from ActualFlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3 and flightNumber=?4")
//    List<ActualFlightsDetails> findByActualDetails(String departureAirport, String departureDay, String arrivalAirport, String flightNumber);
	


//	@Query("from FlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3")
//	List<FlightsDetails> findByReturn(String arrivalAirport, String returnDay, String departureAirport);
//	
//	@Query("from FlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3")
//	List<FlightsDetails> findByDepartAirportArrivalAiportAndDate(String airport1, String departureDay, String airport2);

}
