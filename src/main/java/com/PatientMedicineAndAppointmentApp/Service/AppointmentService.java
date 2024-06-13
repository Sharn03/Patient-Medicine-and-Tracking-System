package com.PatientMedicineAndAppointmentApp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PatientMedicineAndAppointmentApp.Entity.Appointment;
import com.PatientMedicineAndAppointmentApp.Repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	// Method to fetch all the Appointment Details
			public List<Appointment> getAllAppointment()
			{
				List<Appointment> appointmentList = appointmentRepo.findAll();
				return  appointmentList;
			}
			
			
			//Method to fetch Appointment details by appointmentId
			public Appointment getAppointmentById(int id)
			{
				//Declaring the Appointment object to null 
				Appointment appointment = null;
				
				// checking if the id is null or not
				if(Objects.nonNull(id))
				{
				 // here we are using Optional class to check where the object is present or not 
				 Optional<Appointment> optionalAppointment = appointmentRepo.findById(id);
				 
				 if(optionalAppointment.isPresent())
				 {
					 appointment = optionalAppointment.get();
				 }
				 // if the appointment object leads to  null we would a run time error message
				 else
				 {
					throw new RuntimeException("Doctor id "+ id +" Not Found ");
				 }
				 
				}
				 
				 return appointment;
			}
			
			//Method to save Appointment
			public void saveAppointment(Appointment appointment)
			{
				//checking the arguments is null or not
				if(Objects.nonNull(appointment))
				{
					
				 appointmentRepo.save(appointment);
				
				}
			}
			
			
			//Method to update Appointment Details
			public Appointment updateAppointment(Appointment appointment)
			{
				Appointment existingAppointment = null;
				
				if(Objects.nonNull(appointment))
				{
					existingAppointment =  (Appointment) appointmentRepo.findById(appointment.getId()).get();
					existingAppointment.setId(appointment.getId());
					existingAppointment.setName(appointment.getName());
					existingAppointment.setAge(appointment.getAge());
					existingAppointment.setContact(appointment.getContact());
					existingAppointment.setEmail(appointment.getEmail());
					existingAppointment.setGender(appointment.getGender());
					existingAppointment.setDate(appointment.getDate());
					existingAppointment.setRegarding(appointment.getRegarding());
				}
				
				return appointmentRepo.save(existingAppointment);
			}
			
			
			//Method to delete Appointment Details
			public void deleteById(int id)
			{
				if(Objects.nonNull(id))
				{
					appointmentRepo.deleteById(id);
				}
			}
			
	
}
