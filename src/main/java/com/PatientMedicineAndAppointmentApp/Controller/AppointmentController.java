package com.PatientMedicineAndAppointmentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PatientMedicineAndAppointmentApp.Entity.Appointment;
import com.PatientMedicineAndAppointmentApp.Service.AppointmentService;


@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
		@GetMapping("/appointment")
		public String doctor(Model m)
		{
			m.addAttribute("allAppointmentDetails", appointmentService.getAllAppointment());
			return "APPOINTMENT/appointmentIndex";
		}
		
		//End points to book Appointment
		@GetMapping("/bookAppointment")
		public String bookAppointment(Model m)
		{
			Appointment appointment = new Appointment();
			m.addAttribute("appointment", appointment);
			return "APPOINTMENT/bookAppointment";
		}
		
		//End points to save Appointment
		@PostMapping("/saveAppointment")
		public String saveAppointment(@ModelAttribute("appointment") Appointment appointment)
		{
			appointmentService.saveAppointment(appointment);
			return "redirect:/appointment";
		}
		
		//End points to update Appointment
		@GetMapping("/updateAppointment/{id}")
		public String updateAppointment(@PathVariable("id") int id, Model m)
		{
			Appointment appointment = appointmentService.getAppointmentById(id);
			m.addAttribute("appointment", appointment);
			return "APPOINTMENT/updateAppointment";
		}
		
		
		@GetMapping("/deleteAppointment/{id}")
		public String deleteAppointment(@PathVariable("id") int id)
		{
			 appointmentService.deleteById(id);
			 return "redirect:/appointment";
		}

}
