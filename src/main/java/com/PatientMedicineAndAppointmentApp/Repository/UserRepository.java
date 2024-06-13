package com.PatientMedicineAndAppointmentApp.Repository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.PatientMedicineAndAppointmentApp.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	

}
