package com.example.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.AdminsTokenDao;
import com.example.demo.model.Admins;
import com.example.demo.model.AdminsToken;
import com.example.exception.CustomException;
import com.example.user.AdminSignIn;
import com.example.user.AdminSignUp;


@Service
public class AdminService {
	
	@Autowired
	AdminDao ad;
	
	@Autowired
	AdminsTokenDao atd;
	
	public void addAdmins(AdminSignUp signup) {
		
		String encryptedPassword = signup.getPassword();
		
		try {
			encryptedPassword = hashPassword(encryptedPassword);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Admins a = new Admins();
		a.setFirstName(signup.getFirstName());
		a.setLastName(signup.getLastName());
		a.setEmail(signup.getEmail());
		a.setPassword(encryptedPassword);
		ad.save(a);
		
		
		AdminsToken at = new AdminsToken();
//		Random r = new Random();
		String token = UUID.randomUUID().toString();
		at.setToken(token);
		at.setAdmins(a);
		atd.save(at);
		
		
		
	}
	
	private String hashPassword(String password) throws NoSuchAlgorithmException{
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(password.getBytes());
	byte[]digest = md.digest();
	String hash = DatatypeConverter
			.printHexBinary(digest).toUpperCase();
	return hash;
}

	public String signIn(AdminSignIn asi) {
		
		Admins a = ad.findByEmail(asi.getEmail());
		if(Objects.isNull(ad.findByEmail(asi.getEmail()))) {
			throw new CustomException("Wrong id");
			
		}
		try {
			if(asi.getPassword()!=a.getPassword()) {
				throw new CustomException("Wrong password");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
		
		
	}

}
