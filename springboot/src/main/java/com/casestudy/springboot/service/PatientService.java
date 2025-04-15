package com.casestudy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.springboot.model.Medical_History;
import com.casestudy.springboot.model.Patient;
import com.casestudy.springboot.model.User;
import com.casestudy.springboot.repository.AuthRepository;
import com.casestudy.springboot.repository.Medical_HistoryRepository;
import com.casestudy.springboot.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository pr;

    @Autowired
    private Medical_HistoryRepository mhr;


    @Autowired
    private AuthRepository authrepo;
	public Patient addPatientWithHistory(Patient patient, Medical_History medicalHistory, String username) {
		//gettomg the userbyusrname
		 User user = authrepo.findByUsername(username);
				 if (user == null) {
				        throw new RuntimeException("User not found");
				    }
		 
		 //add use to the patient
		 patient.setUser(user);
		 //we have the medial history save to that db first
		mhr.save(medicalHistory);
		 //add medicalg histpry now to the patient after saving it //now after adding the medical history use the set to patinet mediacl hostry
		 patient.setMedical_history(medicalHistory);
		return pr.save(patient);
	}
	
}

