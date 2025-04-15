package com.casestudy.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.casestudy.springboot.model.Doctor;
import com.casestudy.springboot.model.DoctorPatient;
import com.casestudy.springboot.model.Patient;
import com.casestudy.springboot.model.Speciality;
import com.casestudy.springboot.model.User;
import com.casestudy.springboot.repository.DoctorPatientRepository;
import com.casestudy.springboot.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class DoctorPatientServiceTest {
	
	//now we are faking the doctorpatient repository so use mock
	@Mock
	private DoctorPatientRepository dpr;
	
	 @Mock
	    private PatientRepository pr;
	 //we are testin g doctorpatient service so inject mocki used
	    @InjectMocks
	    private DoctorPatientService doctorPatientService;
	    
	    Doctor d1;
	    User u1;
	    Patient p1,p2;
	    DoctorPatient dp1,dp2;
	    @BeforeEach
	    public void init() {
	        d1 = new Doctor(1, "Venkatesh", Speciality.ORTHO);
	        u1 = new User(1, "MSDHONI", "1234", "DOCTOR");
	        
	        p1 = new Patient(1, "karthik", 28, new User(2, "VIRATKOHLI", "1234", "PATIENT"));
	        p2 = new Patient(2, "melvin", 35, new User(3, "RACHINRAVINDRA", "12345", "PATIENT"));
	        
	        dp1 = new DoctorPatient(1, d1, p1);
	        dp2 = new DoctorPatient(2, d1, p2);
	    }
	    //test case 1 for the pattiensrs
	    @Test
	    public void getAllPatientsByDoctorIdTest() {
	       //give the doctor patinetws we faked
	    	
	    	//use case 1 we given valid doctor id
	        List<DoctorPatient> doctorPatients = Arrays.asList(dp1, dp2);
	      //get the ids first
	        List<Integer> expectedPatientIds = Arrays.asList(p1.getId(), p2.getId());
	        
	        //give the ids of the patients 
	        
	        List<Patient> expectedPatients = Arrays.asList(p1, p2);

	        // fke the call by method 
	        when(dpr.findAllDoctorById(1)).thenReturn(doctorPatients);
	        when(pr.findAllById(expectedPatientIds)).thenReturn(expectedPatients);

	        // Actual call of the method
	        //get the expected list
	        List<Patient> result = doctorPatientService.getAllPatientsByDoctorId(1);

	        // get the sixe of patients herw we get 2 
	        assertEquals(2, result.size());
	        //get thename based on listindex 0,1
	        assertEquals("karthik", result.get(0).getName());
	        assertEquals("melvin", result.get(1).getName());         //expected and original is given for thus method

	        // how many times db is called
	        verify(dpr, times(1)).findAllDoctorById(1);
	        
	        
	        //use case 2 we givem invalid doctror id
	        
	        
	        //  no doctor-patient links found
	        when(dpr.findAllDoctorById(3497947)).thenReturn(List.of());

	        
	        List<Patient> no_result = doctorPatientService.getAllPatientsByDoctorId(3497947);

	        
	        assertEquals(0, no_result.size(), "Expected empty list for invalid doctor ID");

	        // how many times db is called
	        verify(dpr, times(1)).findAllDoctorById(3497947);
	        
	    }
	    //test case 2 for appointemnet check
	    @Test
	    public void makeAppointmentTest() {
	        //we have the mocked objects right there d1, p1 add them here 
	        DoctorPatient app = new DoctorPatient();
	        app.setDoctor(d1);
	        app.setPatient(p1);

	        // when save method called give me app
	        when(dpr.save(app)).thenReturn(app);

	        //this is actual
	        DoctorPatient expected = doctorPatientService.makeappointment(app);

	        
	        assertEquals(d1, expected.getDoctor());
	        assertEquals(p1, expected.getPatient());

	        // check how mamy tims dbi s called
	        verify(dpr, times(1)).save(app);
	    }


	

}
