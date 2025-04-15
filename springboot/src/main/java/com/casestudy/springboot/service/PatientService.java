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

public Patient addPatientWithHistory(Patient patient, String username) {
    // get the user by username
    User user = authrepo.findByUsername(username);
    if (user == null) {
        throw new RuntimeException("User not found");
    }

    // set the user to the patient and add
    patient.setUser(user);

    // get medical history from patient 
    Medical_History medicalHistory = patient.getMedical_history();
    
    if (medicalHistory != null) {
        // save the medical history first
        mhr.save(medicalHistory);
        patient.setMedical_history(medicalHistory); 
    } else {
        throw new RuntimeException("Medical History for that patient  is required");
    }

    // save patient with user and medical history
    return pr.save(patient);
	
}

}

