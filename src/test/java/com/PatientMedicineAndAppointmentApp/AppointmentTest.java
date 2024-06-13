package com.PatientMedicineAndAppointmentApp;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.PatientMedicineAndAppointmentApp.Entity.Appointment;
import com.PatientMedicineAndAppointmentApp.Entity.Patient;
import com.PatientMedicineAndAppointmentApp.Repository.AppointmentRepository;
import com.PatientMedicineAndAppointmentApp.Service.AppointmentService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class AppointmentTest {
	

    @Mock
    private AppointmentRepository appointmentRepo;

    @InjectMocks
    private AppointmentService appointmentService;



    @Test
    public void testGetAllAppointment() {
        
    	Appointment appointment = new Appointment();
    	Appointment appointment1 = new Appointment();
    	
        List<Appointment> appointmentList = new ArrayList<>();
        
         appointment.setId(1);
         appointment.setName("John");
         appointment.setAge(30);
         appointment.setGender("Male");
         appointment.setContact("1234567890");
         appointment.setEmail("john@example.com");
         appointment.setDate("06-10-2023 10:00 AM");
         appointment.setRegarding("Consultation");
         
         appointment1.setId(2);
         appointment1.setName("Kishan");
         appointment1.setAge(30);
         appointment1.setGender("Male");
         appointment1.setContact("0987654321");
         appointment1.setEmail("kishan@example.com");
         appointment1.setDate("06-10-2023 11:00 AM");
         appointment1.setRegarding("Checkup");
         
         appointmentList.add(appointment);
         appointmentList.add(appointment1);
         
         
         
         when(appointmentRepo.findAll()).thenReturn(appointmentList);
       
         List<Appointment> result = appointmentService.getAllAppointment();
         assertEquals(1, result.get(0).getId());
		 assertEquals("John", result.get(0).getName());
		 assertEquals(30, result.get(0).getAge());
		 assertEquals("Male", result.get(0).getGender());
		 assertEquals("1234567890", result.get(0).getContact());
		 assertEquals("john@example.com", result.get(0).getEmail());
	     assertEquals("06-10-2023 10:00 AM", result.get(0).getDate());
	     assertEquals("Consultation",result.get(0).getRegarding());
	     
	     assertEquals(2, result.get(1).getId());
		 assertEquals("Kishan", result.get(1).getName());
		 assertEquals(30, result.get(1).getAge());
		 assertEquals("Male", result.get(1).getGender());
		 assertEquals("0987654321", result.get(1).getContact());
		 assertEquals("kishan@example.com", result.get(1).getEmail());
	     assertEquals("06-10-2023 11:00 AM", result.get(1).getDate());
	     assertEquals("Checkup",result.get(1).getRegarding());
	     
	   }
    

    @Test
    public void testUpdateAppointment() {
      
        Appointment appointment = new Appointment();
        appointment.setId(1);
        appointment.setName("John");
        appointment.setAge(30);
        appointment.setGender("Male");
        appointment.setContact("1234567890");
        appointment.setEmail("john@example.com");
        appointment.setDate("06-15-2023 10:00 AM");
        appointment.setRegarding("Check-up");

        Appointment updatedAppointment = new Appointment();
        updatedAppointment.setId(1);
        updatedAppointment.setName("John Doe");
        updatedAppointment.setAge(31);
        updatedAppointment.setGender("Male");
        updatedAppointment.setContact("0987654321");
        updatedAppointment.setEmail("johndoe@example.com");
        updatedAppointment.setDate("06-16-2023 11:00 AM");
        updatedAppointment.setRegarding("Follow-up");

        when(appointmentRepo.findById(1)).thenReturn(Optional.of(appointment));
        when(appointmentRepo.save(org.mockito.ArgumentMatchers.any(Appointment.class))).thenReturn(updatedAppointment);
   
       
        Appointment result = appointmentService.updateAppointment(updatedAppointment);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals(31, result.getAge());
        assertEquals("Male", result.getGender());
        assertEquals("0987654321", result.getContact());
        assertEquals("johndoe@example.com", result.getEmail());
        assertEquals("06-16-2023 11:00 AM", result.getDate());
        assertEquals("Follow-up", result.getRegarding());
    }

}
