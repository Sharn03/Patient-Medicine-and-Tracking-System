package com.PatientMedicineAndAppointmentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PatientMedicineAndAppointmentApp.Entity.Patient;
import com.PatientMedicineAndAppointmentApp.Entity.User;
import com.PatientMedicineAndAppointmentApp.Service.UserService;

@Controller

public class UserController {
	
	@Autowired
	private UserService userService;

	
		
		@GetMapping("/user")
		public String user(Model m)
		{
			m.addAttribute("allUserDetails", userService.getAllUser());
			return "USER/userIndex";
		}
		
		//End points to add new User
		@GetMapping("/addNewUser")
		public String addNewUser(Model m)
		{
			User user = new User ();
			m.addAttribute("user", user);
			return "USER/addUser";
		}
		
		//End points to save User
		@PostMapping("/saveUser")
		public String saveUser(@ModelAttribute("user") User user)
		{
			userService.saveUser(user);
			return "redirect:/user";
		}
		
		//End points to update employee
		@GetMapping("/updateUser/{id}")
		public String updateUser(@PathVariable("id") int id, Model m)
		{
			User user = userService.getUsertById(id);
			m.addAttribute("user", user);
			return "USER/updateUser";
		}
		
		
		@GetMapping("/deleteUser/{id}")
		public String deleteUser(@PathVariable("id") int id)
		{
			 userService.deleteById(id);
			 return "redirect:/user";
		}
}
