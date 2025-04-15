package com.casestudy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.springboot.model.Patient;


 public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
