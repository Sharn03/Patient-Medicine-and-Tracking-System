package com.PatientMedicineAndAppointmentApp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PatientMedicineAndAppointmentApp.Entity.Doctor;
import com.PatientMedicineAndAppointmentApp.Repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepo;
	
	// Method to fetch all the Doctor Details
		public List<Doctor> getAllDoctor()
		{
			List<Doctor> doctorList = doctorRepo.findAll();
			return doctorList;
		}
		
		
		//Method to fetch Doctor details by DoctorId
		public Doctor getDoctorById(int id)
		{
			//Declaring the Doctor object to null 
			Doctor doctor = null;
			
			// checking if the id is null or not
			if(Objects.nonNull(id))
			{
			 // here we are using Optional class to check where the object is present or not 
			 Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
			 
			 if(optionalDoctor.isPresent())
			 {
				 doctor = optionalDoctor.get();
			 }
			 // if the doctor object leads to  null we would a run time error message
			 else
			 {
				throw new RuntimeException("Doctor id "+ id +" Not Found ");
			 }
			 
			}
			 
			 return doctor;
		}
		
		//Method to save Doctor
		public void saveDoctor(Doctor doctor)
		{
			//checking the arguments is null or not
			if(Objects.nonNull(doctor))
			{
				
			 doctorRepo.save(doctor);
			
			}
		}
		
		
		//Method to update Doctor Details
		public Doctor updateDoctor(Doctor doctor)
		{
			Doctor existingDoctor = null;
			
			if(Objects.nonNull(doctor))
			{
				existingDoctor =  (Doctor) doctorRepo.findById(doctor.getDoctorId()).get();
				existingDoctor.setDoctorId(doctor.getDoctorId());
				existingDoctor.setDoctorName(doctor.getDoctorName());
				existingDoctor.setDoctorAge(doctor.getDoctorAge());
				existingDoctor.setDoctorContact(doctor.getDoctorContact());
				existingDoctor.setDoctorSpecialization(doctor.getDoctorSpecialization());
			}
			
			return doctorRepo.save(existingDoctor);
		}
		
		
		//Method to delete Doctor Details
		public void deleteById(int id)
		{
			if(Objects.nonNull(id))
			{
				doctorRepo.deleteById(id);
			}
		}
		

}
