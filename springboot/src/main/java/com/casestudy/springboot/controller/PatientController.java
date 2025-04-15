package com.casestudy.springboot.controller;

import java.security.Principal;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.casestudy.springboot.model.Patient;

import com.casestudy.springboot.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private PatientService ps;
	
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient patient) {   
	    return ps.addPatientWithHistory(patient);
	}
}	
