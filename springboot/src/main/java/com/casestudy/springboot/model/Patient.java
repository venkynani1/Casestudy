package com.casestudy.springboot.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
@Entity
public class Patient {
	
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int id;
		 
		    @Column(nullable = false)
		    private String name;
		    
		    @Column(nullable = false)
		    private int age;
		    
		   

			

			public Patient(int id, String name, int age, User user, Medical_History medical_history) {
				super();
				this.id = id;
				this.name = name;
				this.age = age;
				this.user = user;
				this.medical_history = medical_history;
			}

			//one to one relation with user
		    @OneToOne
		    private User user;
		    //has one to one raltion with patient 
			 @OneToOne
			 private Medical_History medical_history;

			
			public Patient() {
				super();
				// TODO Auto-generated constructor stub
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

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Medical_History getMedical_history() {
				return medical_history;
			}

			public void setMedical_history(Medical_History medical_history) {
				this.medical_history = medical_history;
			}

			public Patient(int id, String name, int age, User user) {
				super();
				this.id = id;
				this.name = name;
				this.age = age;
				this.user = user;
			}


}