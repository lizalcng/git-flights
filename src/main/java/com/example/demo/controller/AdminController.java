package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AdminService;
import com.example.user.AdminSignIn;
import com.example.user.AdminSignUp;


@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AdminService as;
	
	@PostMapping("/signup")
	public ResponseEntity<String> addAdmins(@RequestBody AdminSignUp signup) {
		as.addAdmins(signup);
		return new ResponseEntity<>("success",HttpStatus.OK);
		
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<String> signInAdmin(@RequestBody AdminSignIn signIn){
		as.signIn(signIn);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
}
