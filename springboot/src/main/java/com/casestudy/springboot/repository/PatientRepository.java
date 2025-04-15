package com.casestudy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.springboot.model.Patient;
import com.casestudy.springboot.model.User;


 public interface PatientRepository extends JpaRepository<Patient, Integer> {

	User findByUser(User user);

}
