package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.SeatsService;

@RestController
@RequestMapping("/seats")
public class SeatsController {
	
	@Autowired
	SeatsService seatService;
	
	@PostMapping(value="/postSeats", consumes= {"multipart/form-data"})
	public ResponseEntity<String> postSeats(@RequestPart("file") MultipartFile file) {
		try {
			seatService.postSeats(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("success",HttpStatus.OK);
 
		
	}

}
