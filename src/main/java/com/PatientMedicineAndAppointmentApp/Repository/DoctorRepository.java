package com.PatientMedicineAndAppointmentApp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PatientMedicineAndAppointmentApp.Entity.Doctor;
@Repository
public interface DoctorRepository  extends JpaRepository<Doctor,Integer>{
	
	
}
