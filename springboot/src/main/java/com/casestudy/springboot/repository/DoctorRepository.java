package com.casestudy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.springboot.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
