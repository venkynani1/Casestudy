package com.casestudy.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DoctorPatient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	//relatipnoships
	@ManyToOne
	private Doctor doctor;
	@ManyToOne
	private Patient patient;
	public DoctorPatient(int id, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public DoctorPatient(Doctor doctor, Patient patient) {
		super();
		this.doctor = doctor;
		this.patient = patient;
	}
	public DoctorPatient() {
		// TODO Auto-generated constructor stub
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
