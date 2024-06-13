package com.PatientMedicineAndAppointmentApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import org.springframework.boot.test.context.SpringBootTest;

import com.PatientMedicineAndAppointmentApp.Entity.Patient;
import com.PatientMedicineAndAppointmentApp.Repository.PatientRepository;
import com.PatientMedicineAndAppointmentApp.Service.PatientService;

@SpringBootTest

@ExtendWith(MockitoExtension.class)
class PatientMedicineAndAppointmentAppApplicationTests {
	@Mock
	private PatientRepository patientRepo;
	
	@InjectMocks
	private PatientService patientService;
	
	@Test
	public void testGetPatient()
	{
		Patient patient1 = new Patient();
		Patient patient2 = new Patient();
		
		
		patient1.setPatientId(1);
		patient1.setPatientName("john");
	    patient1.setPatientAge(23);
	    patient1.setPatientContact("12345");
	    patient1.setPatientMedicalHistory("fever");
	    patient1.setPatientPrescription("paracetomal");
	    patient1.setPatientHealthStatus("recovering");
	    
	    patient2.setPatientId(2);
		patient2.setPatientName("kishan");
	    patient2.setPatientAge(23);
	    patient2.setPatientContact("002345");
	    patient2.setPatientMedicalHistory("cold");
	    patient2.setPatientPrescription("paracetomal");
	    patient2.setPatientHealthStatus("better");
	    
	    List<Patient>list = new ArrayList<>();
	    list.add(patient1);
	    list.add(patient2);
	    
		when(patientRepo.findAll()).thenReturn(list);
		
		List<Patient> result = patientService.getAllPatient();

		 assertEquals(1, result.get(0).getPatientId());
		 assertEquals("john", result.get(0).getPatientName());
		 assertEquals(23, result.get(0).getPatientAge());
		 assertEquals("12345", result.get(0).getPatientContact());
		 assertEquals("fever", result.get(0).getPatientMedicalHistory());
		 assertEquals("paracetomal", result.get(0).getPatientPrescription());
	     assertEquals("recovering", result.get(0).getPatientHealthStatus());
	     
	     assertEquals(2, result.get(1).getPatientId());
		 assertEquals("kishan", result.get(1).getPatientName());
		 assertEquals(23, result.get(1).getPatientAge());
		 assertEquals("002345", result.get(1).getPatientContact());
		 assertEquals("cold", result.get(1).getPatientMedicalHistory());
		 assertEquals("paracetomal", result.get(1).getPatientPrescription());
	     assertEquals("better", result.get(1).getPatientHealthStatus());
		
	}
	
	 @Test
	    public void testUpdatePatient()
	 {
	    
		  Patient patient = new Patient();
		  patient.setPatientId(1);
		  patient.setPatientName("john");
		  patient.setPatientAge(23);
		  patient.setPatientContact("12345");
		  patient.setPatientMedicalHistory("fever");
		  patient.setPatientPrescription("paracetomal");
		  patient.setPatientHealthStatus("recovering");
		  
		  
		  Patient updatedPatient = new Patient();
		  updatedPatient.setPatientId(1);
		  updatedPatient.setPatientName("john");
		  updatedPatient.setPatientAge(23);
		  updatedPatient.setPatientContact("12345");
		  updatedPatient.setPatientMedicalHistory("fever");
		  updatedPatient.setPatientPrescription("paracetomal");
		  updatedPatient.setPatientHealthStatus("better");
	      
          when(patientRepo.findById(1)).thenReturn(Optional.of(patient));
          when(patientRepo.save(any(Patient.class))).thenReturn(updatedPatient);
          
         Patient result = patientService.updatePatient(updatedPatient);
         assertNotNull(result);
         assertEquals("john", result.getPatientName());
         assertEquals("better", result.getPatientHealthStatus());
       
	 }
	 
	 @Test
	 public void testSavePatient()
	 {
		 Patient patient = new Patient();
		  patient.setPatientId(1);
		  patient.setPatientName("john");
		  patient.setPatientAge(23);
		  patient.setPatientContact("12345");
		  patient.setPatientMedicalHistory("fever");
		  patient.setPatientPrescription("paracetomal");
		  patient.setPatientHealthStatus("recovering");
		 patientService.savePatient(patient);
		 verify(patientRepo, times(1)).save(patient);
	       
	   }

	
	
}
