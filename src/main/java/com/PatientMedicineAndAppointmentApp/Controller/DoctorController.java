package com.PatientMedicineAndAppointmentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PatientMedicineAndAppointmentApp.Entity.Doctor;
import com.PatientMedicineAndAppointmentApp.Service.DoctorService;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
		@GetMapping("/doctor")
		public String doctor(Model m)
		{
			m.addAttribute("allDoctorDetails", doctorService.getAllDoctor());
			return "DOCTOR/doctorIndex";
		}
		
		//End points to add new Doctor
		@GetMapping("/addNewDoctor")
		public String addNewDoctor(Model m)
		{
			Doctor doctor = new Doctor();
			m.addAttribute("doctor", doctor);
			return "DOCTOR/addDoctor";
		}
		
		//End points to save Doctor
		@PostMapping("/saveDoctor")
		public String saveDoctor(@ModelAttribute("doctor") Doctor doctor)
		{
			doctorService.saveDoctor(doctor);
			return "redirect:/doctor";
		}
		
		//End points to update employee
		@GetMapping("/updateDoctor/{id}")
		public String updateDoctor(@PathVariable("id") int id, Model m)
		{
			Doctor doctor = doctorService.getDoctorById(id);
			m.addAttribute("doctor", doctor);
			return "DOCTOR/updateDoctor";
		}
		
		
		@GetMapping("/deleteDoctor/{id}")
		public String deleteDoctor(@PathVariable("id") int id)
		{
			 doctorService.deleteById(id);
			 return "redirect:/doctor";
		}
}
