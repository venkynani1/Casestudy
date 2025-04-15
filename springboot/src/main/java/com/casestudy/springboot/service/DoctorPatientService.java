package com.casestudy.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.springboot.model.DoctorPatient;
import com.casestudy.springboot.model.Patient;
import com.casestudy.springboot.repository.DoctorPatientRepository;
import com.casestudy.springboot.repository.PatientRepository;

@Service
public class DoctorPatientService {
	@Autowired
	private DoctorPatientRepository dpr;
	@Autowired
	private PatientRepository pr;
	public List<Patient> getAllPatientsByDoctorId(int dId) {
		//get all doctor patient links for id
        List<DoctorPatient> validids= dpr.findAllDoctorById(dId);
      //create a new list for adding patients  they return integers of id 
      		//extract the ids using stream
        List<Integer> patients = validids.stream()
                .map(dp -> dp.getPatient().getId())
                .toList();

        return pr.findAllById(patients);
    }
	public DoctorPatient makeappointment(DoctorPatient dp) {
		return dpr.save(dp);
	}

}	
