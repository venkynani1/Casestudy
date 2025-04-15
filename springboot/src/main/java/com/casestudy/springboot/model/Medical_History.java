package com.casestudy.springboot.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medical_History {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
	 @Column(nullable = false)
	    private String illness;
	 @Column(nullable = false)
	 private int no_of_years;
	 /*we use length attribute because the lenght should be 1000 mentoined*/
	 @Column(nullable = false, length=1000)
	 private String current_medication;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public int getNo_of_years() {
		return no_of_years;
	}
	public void setNo_of_years(int no_of_years) {
		this.no_of_years = no_of_years;
	}
	public String getCurrent_medication() {
		return current_medication;
	}
	public void setCurrent_medication(String current_medication) {
		this.current_medication = current_medication;
	}
	public Medical_History(int id, String illness, int no_of_years, String current_medication) {
		super();
		this.id = id;
		this.illness = illness;
		this.no_of_years = no_of_years;
		this.current_medication = current_medication;
	}
	public Medical_History(String illness, int no_of_years, String current_medication) {
		super();
		this.illness = illness;
		this.no_of_years = no_of_years;
		this.current_medication = current_medication;
	}
}