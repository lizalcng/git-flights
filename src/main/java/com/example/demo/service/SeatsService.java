package com.example.demo.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.SeatsDao;
import com.example.demo.model.Seats;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.example.dto.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatsService {
	
	@Autowired
	SeatsDao seatsRepo;

	public String postSeats(MultipartFile file) throws IOException {
		Set<Seats> seats = parseCsv(file);
		seatsRepo.saveAll(seats);
		return "Success";
	}
	
	private Set<Seats> parseCsv(MultipartFile file) throws IOException {
	    try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
	        HeaderColumnNameMappingStrategy<SeatsCsv> strategy = new HeaderColumnNameMappingStrategy<>();
	        strategy.setType(SeatsCsv.class);

	        CsvToBean<SeatsCsv> csvToBean = new CsvToBeanBuilder<SeatsCsv>(reader)
	                .withMappingStrategy(strategy)
	                .withIgnoreEmptyLine(true)
	                .withIgnoreLeadingWhiteSpace(true)
	                .build();

	        List<SeatsCsv> csvData = csvToBean.parse();
	        
	        // Log CSV data to ensure it's parsed correctly
	        for (SeatsCsv row : csvData) {
	            System.out.println("Parsed CSV Row - SeatNumber: " + row.getSeatNumber() +
	                               ", SeatClass: " + row.getSeatClass() +
	                               ", IsAvailable: " + row.getisAvailable() +
	                               ", Price: " + row.getPrice());
	        }

	        return csvData.stream()
	                .map(csvRow -> {
	                    Seats seat = new Seats();
	                    seat.setSeatNumber(csvRow.getSeatNumber());
	                    seat.setSeatClass(csvRow.getSeatClass());
	                    seat.setAvailable(csvRow.getisAvailable());
	                    seat.setPrice(csvRow.getPrice());
	                    return seat;
	                })
	                .collect(Collectors.toSet());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
//	
//	private Set<Seats> parseCsv(MultipartFile file) throws IOException {
//	    try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//	        HeaderColumnNameMappingStrategy<SeatsCsv> strategy = new HeaderColumnNameMappingStrategy<>();
//	        strategy.setType(SeatsCsv.class);
//
//	        CsvToBean<SeatsCsv> csvToBean = new CsvToBeanBuilder<SeatsCsv>(reader)
//	                .withMappingStrategy(strategy)
//	                .withIgnoreEmptyLine(true)
//	                .withIgnoreLeadingWhiteSpace(true)
//	                .build();
//
//	        Set<Seats> test = csvToBean.parse()
//	                .stream()
//	                .map(csvLive -> Seats.builder()
//	                        .setSeatNumber(csvLive.getSeatNumber())
//	                        .setSeatClass(csvLive.getSeatClass())
//	                        .setisAvailable(csvLive.getisAvailable())
//	                        .setprice(csvLive.getPrice())
//	                        .build()
//	                )
//	                .collect(Collectors.toSet());
//	        
//	        System.out.println(test);
//	        
//	        return test;
//		
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return null;
//	}
	
//	private Set<Seats> parseCsv(MultipartFile file) throws IOException{
//		
//		try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
//			HeaderColumnNameMappingStrategy<SeatsCsv> strategy = new HeaderColumnNameMappingStrategy<>();
//			strategy.setType(SeatsCsv.class);
//			CsvToBean<SeatsCsv> csvToBean = new CsvToBeanBuilder<SeatsCsv>(reader)
//					.withMappingStrategy(strategy).withIgnoreEmptyLine(true)
//					.withIgnoreLeadingWhiteSpace(true)
//					.build();
//			
//			
////			return csvToBean.parse()
////				    .stream()
////				    .map(csvLive -> Seats.builder()
////				    		.setSeatNumber(csvLive.getSeatNumber())
////				    		.setSeatClass(csvLive.getSeatClass())
////				    		.setisAvailable(csvLive.getisAvailable())
////				    		.setprice(csvLive.getPrice())
////				    		.build()
////				    		)
////				    .collect(Collectors.toSet());
//					
//			
//			List<Seats> test = csvToBean.parse()
//		    .stream()
//		    .map(csvLive -> {
//		    	Seats s = new Seats();
//				System.out.println(csvLive);
//		    	s.setSeatNumber(csvLive.getSeatNumber());
//		    	return s;
//		    })
//		    .collect(Collectors.toList());
//			
////			List<Seats> test1 = new ArrayList<>();
////			for(int i = 0; i < csvToBean.parse().size(); i++) {
////				SeatsCsv csvline = csvToBean.parse().get(i);
////				Seats s = new Seats();
////				s.setSeatNumber(csvline.getSeatNumber());
////				test1.add(s);
////			}
//			
////			

////			System.out.println(test1);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

}
