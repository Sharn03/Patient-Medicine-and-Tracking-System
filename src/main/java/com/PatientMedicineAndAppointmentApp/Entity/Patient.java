package com.PatientMedicineAndAppointmentApp.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patient")
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientContact;
	private String patientMedicalHistory;
	private String patientPrescription;
	
	public String getPatientPrescription() {
		return patientPrescription;
	}
	public void setPatientPrescription(String patientPrescription) {
		this.patientPrescription = patientPrescription;
	}
	private String patientHealthStatus;
	
	
	
	public String getPatientHealthStatus() {
		return patientHealthStatus;
	}
	public void setPatientHealthStatus(String patientHealthStatus) {
		this.patientHealthStatus = patientHealthStatus;
	}

	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}
	public String getPatientMedicalHistory() {
		return patientMedicalHistory;
	}
	public void setPatientMedicalHistory(String patientMedicalHistory) {
		this.patientMedicalHistory = patientMedicalHistory;
	}
	
	
	
	
	
	
}
