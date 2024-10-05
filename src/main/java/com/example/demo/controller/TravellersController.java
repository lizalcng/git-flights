package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravellersInfo;
import com.example.demo.service.TravellersService;
import com.example.dto.TravellersDto;

@RestController
@RequestMapping("/travellers")
public class TravellersController {
	
	@Autowired
	TravellersService travelservice;
	
	@PostMapping("/postTravellers")
	public ResponseEntity<String> addTravellers(@RequestBody TravellersDto travellers, @RequestParam ("flightNumber") String flightNumber){
		travelservice.postTravellers(travellers,flightNumber);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}

}
