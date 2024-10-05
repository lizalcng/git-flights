//package com.example.demo.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.example.dto.ActualFlightsDetails;
//
//@Repository
//public interface ActualFlightsDetailsDao extends JpaRepository<ActualFlightsDetails,Integer> {
//	
//	@Query("from ActualFlightsDetails where departureAirport=?1 and departureDay=?2 and arrivalAirport=?3 and flightNumber=?4")
//	List<ActualFlightsDetails> findByActualDetails(String departureAirport, String departureDay, String arrivalAirport, String flightNumber);
//
//}
