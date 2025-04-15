package com.casestudy.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.casestudy.springboot.model.Medical_History;
import com.casestudy.springboot.model.Patient;
import com.casestudy.springboot.model.User;
import com.casestudy.springboot.repository.Medical_HistoryRepository;
import com.casestudy.springboot.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository pr;

    @Autowired
    private Medical_HistoryRepository mhr;


  

public Patient addPatientWithHistory(Patient patient) {
    // get the user 
	User user=patient.getUser();
    if (user == null) {
        throw new RuntimeException("User not found");
    }
    // set the user to the patient and add
    patient.setUser(user);
    // get medical history from patient 
    Medical_History medicalHistory = patient.getMedical_history();
    //add that medicalhistory to patient
        patient.setMedical_history(medicalHistory); 
    
    // save patient with user and medical history
    return pr.save(patient);
	
}

}

