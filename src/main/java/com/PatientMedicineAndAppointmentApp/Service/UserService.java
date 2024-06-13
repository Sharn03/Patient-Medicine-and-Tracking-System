package com.PatientMedicineAndAppointmentApp.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PatientMedicineAndAppointmentApp.Entity.User;
import com.PatientMedicineAndAppointmentApp.Entity.User;
import com.PatientMedicineAndAppointmentApp.Entity.User;
import com.PatientMedicineAndAppointmentApp.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	// Method to fetch all the User Details
		public List<User> getAllUser()
		{
			List<User> userList = userRepo.findAll();
			return userList;
		}
		
		//Method to save User
		public void saveUser(User user)
		{
			//checking the arguments is null or not
			if(Objects.nonNull(user))
			{
				
			 userRepo.save(user);
			
			}
		}
		
		public User updateUser(User user)
		{
			User existingUser = null;
			
			if(Objects.nonNull(user))
			{
				existingUser =  (User) userRepo.findById(user.getId()).get();
				existingUser.setName(user.getName());
				existingUser.setAge(user.getAge());
				existingUser.setContact(user.getContact());
				existingUser.setMedicalHistory(user.getMedicalHistory());
			
			}
			
			return userRepo.save(existingUser);
		}
		
		
		public User getUsertById(int id)
		{
			//Declaring the Patient object to null 
			User user = null;
			
			// checking if the id is null or not
			if(Objects.nonNull(id))
			{
			 // here we are using Optional class to check where the object is present or not 
			 Optional<User> optionalUser = userRepo.findById(id);
			 
			 if(optionalUser.isPresent())
			 {
				 user = optionalUser.get();
			 }
			 // if the Patient object leads to  null we would a run time error message
			 else
			 {
				throw new RuntimeException("User id "+ id +" Not Found ");
			 }
			 
			}
			 
			 return user;
		}
		
		
		//Method to delete Patient Details
		public void deleteById(int id)
		{
			if(Objects.nonNull(id))
			{
				userRepo.deleteById(id);
			}
		}
		
		
		
		
		
		
}
