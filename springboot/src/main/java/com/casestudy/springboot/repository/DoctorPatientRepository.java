package com.casestudy.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.springboot.model.DoctorPatient;

public interface DoctorPatientRepository  extends JpaRepository<DoctorPatient, Integer>{

	List<DoctorPatient> findAllDoctorById(int dId);

}
