package com.example.demo.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConfirmationTokenDao;
import com.example.demo.dao.TravellersInfoDao;
import com.example.demo.model.ConfirmationToken;
import com.example.demo.model.EmaillSender;
import com.example.demo.model.FlightsDetails;
import com.example.demo.model.TravellersInfo;
import com.example.dto.TravellersDto;

@Service
public class TravellersService {
	
	@Autowired
	EmaillSender mailsender;
	
	@Autowired
	TravellersInfoDao travelrepo;
	
	@Autowired
	ConfirmationTokenDao confirmationdrepo;
	
	@Autowired
	FlightDetailsService flyService;
	
	public void postTravellers(TravellersDto travellers, String flightNumber) {
		TravellersInfo t = new TravellersInfo();
		FlightsDetails fd = flyService.confirmFlight(flightNumber);
			t.setFirstName(travellers.getFirstName());
			t.setLastName(travellers.getLastName());
			t.setEmail(travellers.getEmail());
			t.setGender(travellers.getGender());
			t.setDateOfBirth(travellers.getDateOfBirth());
			t.setFlightdetails(fd);
			travelrepo.save(t);

		

		
		ConfirmationToken token = new ConfirmationToken();
		String random = UUID.randomUUID().toString();
		token.setTravellers(t);
		token.setToken(random);
		confirmationdrepo.save(token);
		try {
			mailsender.sendMail(travellers.getEmail(),token.getToken());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
