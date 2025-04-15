package com.casestudy.springboot.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.springboot.model.Medical_History;
import com.casestudy.springboot.model.Patient;

import com.casestudy.springboot.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private PatientService ps;
	
	@PostMapping("/addpatient")
	public Patient registerPatient(@RequestBody Patient patient, Principal principal) {
		//get the username after logging ign
	    String username = principal.getName();
	    return ps.addPatientWithHistory(patient, username);
	}
}
