package com.PatientMedicineAndAppointmentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PatientMedicineAndAppointmentApp.Entity.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
