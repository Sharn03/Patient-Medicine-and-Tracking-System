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
import com.PatientMedicineAndAppointmentApp.Service.PatientService;
@Controller
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	//End point for accessing the home page
	@GetMapping("/home")
	public String home()
	{
		
		return "HOME/home";
	}
	
	@GetMapping("/patient")
	public String patient(Model m)
	{
		m.addAttribute("allPatientDetails", patientService.getAllPatient());
		return "PATIENT/patientIndex";
	}
	
	//End points to add new patient
	@GetMapping("/addNewPatient")
	public String addNewPatient(Model m)
	{
		Patient patient = new Patient();
		m.addAttribute("patient", patient);
		return "PATIENT/addPatient";
	}
	
	//End points to save Patient
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient)
	{
		patientService.savePatient(patient);
		return "redirect:/patient";
	}
	
	//End points to update employee
	@GetMapping("/updatePatient/{id}")
	public String updatePatient(@PathVariable("id") int id, Model m)
	{
		Patient patient = patientService.getPatientById(id);
		m.addAttribute("patient", patient);
		return "PATIENT/updatePatient";
	}
	
	
	@GetMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable("id") int id)
	{
		 patientService.deleteById(id);
		 return "redirect:/patient";
	}
	

}
