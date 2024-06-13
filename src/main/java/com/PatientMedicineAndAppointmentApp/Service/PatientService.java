package com.PatientMedicineAndAppointmentApp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.PatientMedicineAndAppointmentApp.Entity.Patient;
import com.PatientMedicineAndAppointmentApp.Repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepo;
	
	// Method to fetch all the Patient Details
		public List<Patient> getAllPatient()
		{
			List<Patient> patientList = patientRepo.findAll();
			return patientList;
		}
		
		
		//Method to fetch Patient details by EmployeeId
		public Patient getPatientById(int id)
		{
			//Declaring the Patient object to null 
			Patient patient = null;
			
			// checking if the id is null or not
			if(Objects.nonNull(id))
			{
			 // here we are using Optional class to check where the object is present or not 
			 Optional<Patient> optionalPatient = patientRepo.findById(id);
			 
			 if(optionalPatient.isPresent())
			 {
				 patient = optionalPatient.get();
			 }
			 // if the Patient object leads to  null we would a run time error message
			 else
			 {
				throw new RuntimeException("Patient id "+ id +" Not Found ");
			 }
			 
			}
			 
			 return patient;
		}
		
		//Method to save Patient 
		public void savePatient(Patient patient)
		{
			//checking the arguments is null or not
			if(Objects.nonNull(patient))
			{
				
			 patientRepo.save(patient);
			
			}
		}
		
		
		//Method to update Patient Details
		public Patient updatePatient(Patient patient)
		{
			Patient existingPatient = null;
			
			if(Objects.nonNull(patient))
			{
				existingPatient =  (Patient) patientRepo.findById(patient.getPatientId()).get();
				existingPatient.setPatientId(patient.getPatientId());
				existingPatient.setPatientName(patient.getPatientName());
				existingPatient.setPatientAge(patient.getPatientAge());
				existingPatient.setPatientContact(patient.getPatientContact());
				existingPatient.setPatientMedicalHistory(patient.getPatientMedicalHistory());
			}
			
			return patientRepo.save(existingPatient);
		}
		
		
		//Method to delete Patient Details
		public void deleteById(int id)
		{
			if(Objects.nonNull(id))
			{
				patientRepo.deleteById(id);
			}
		}

}
