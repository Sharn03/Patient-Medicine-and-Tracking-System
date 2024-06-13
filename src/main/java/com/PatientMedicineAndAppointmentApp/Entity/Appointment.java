package com.PatientMedicineAndAppointmentApp.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Appointment")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String gender;
	private String contact;
	private String email;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private String date;
    
	@DateTimeFormat(pattern = "HH-mm")
	private String timing;
	
    public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	private String regarding;
    
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRegarding() {
		return regarding;
	}
	public void setRegarding(String regarding) {
		this.regarding = regarding;
	}
    
    
}
