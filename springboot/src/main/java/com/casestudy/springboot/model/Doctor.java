package com.casestudy.springboot.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;

@Entity
public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 
	    @Column(nullable = false)
	    private String name;
	    
	            /*enum type*/ 
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private Speciality speciality;
	    
	    

		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}

		




		public Doctor(String name, Speciality speciality, User user) {
			super();
			this.name = name;
			this.speciality = speciality;
			this.user = user;
			
		}



		public Doctor(int id, String name, Speciality speciality, User user) {
			super();
			this.id = id;
			this.name = name;
			this.speciality = speciality;
			this.user = user;
			
		}



		



		public Doctor(int id, String name, Speciality speciality) {
			super();
			this.id = id;
			this.name = name;
			this.speciality = speciality;
		}







		//one to one relation with user
	    @OneToOne
	    private User user;
	   
	   

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Speciality getSpeciality() {
			return speciality;
		}

		public void setSpeciality(Speciality speciality) {
			this.speciality = speciality;
		}

}
