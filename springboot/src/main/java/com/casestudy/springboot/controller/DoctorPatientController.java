package com.casestudy.springboot.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.springboot.model.Doctor;
import com.casestudy.springboot.model.DoctorPatient;
import com.casestudy.springboot.model.Patient;

import com.casestudy.springboot.repository.DoctorRepository;
import com.casestudy.springboot.repository.PatientRepository;
import com.casestudy.springboot.service.DoctorPatientService;

@RestController
@RequestMapping("/api/doctorpatient")
public class DoctorPatientController {
	

	@Autowired
	private DoctorRepository dr;
	
	@Autowired
	private PatientRepository pr;
	@Autowired 
	private DoctorPatientService dps;
	
	@PostMapping("/postappointment/{dId}/{pId}")
	public DoctorPatient postAppointment(@PathVariable int dId, @PathVariable int pId) {
		//check if the doctor id exists if not throw exception
	    Optional<Doctor> doctor = dr.findById(dId);
	  //check if the patient id exists if not throw exception
	    Optional<Patient> patient = pr.findById(pId);

	    if (doctor.isEmpty()) {
	        throw new RuntimeException("Doctor not found with the id");
	    }

	    if (patient.isEmpty()) {
	        throw new RuntimeException("Patient not found with given id");
	    }
//create dp
	    DoctorPatient dp = new DoctorPatient();
	    //add the doctor
	    dp.setDoctor(doctor.get());
	    //add the patient
	    dp.setPatient(patient.get());

	    return dps.makeappointment(dp);
	}
	
	//api for geting patients by doctro id
	
	
	 @GetMapping("/patientsbydoctor/{dId}")
	    public List<Patient> getAllByDoctorId(@PathVariable int dId) {
	        return dps.getAllPatientsByDoctorId(dId);
	    }
}