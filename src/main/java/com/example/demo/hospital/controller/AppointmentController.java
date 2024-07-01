package com.example.demo.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.hospital.entity.Patient;
import com.example.demo.hospital.service.AppointmentService;
import com.example.demo.hospital.service.PatientService;

@Controller
public class AppointmentController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private AppointmentService appointmentService;
//  @GetMapping("/appointments")
//  public String listAppointments(Model model) {
//      model.addAttribute("appointments", appointmentService.findAll());
//      return "appointment-list";
//  }

//    @GetMapping("/available")
//    public String showAvailableAppointments(Model model) {
//        List<LocalDateTime> availableAppointments = appointmentService.findAvailableAppointmentsForNextWeek();
//        model.addAttribute("availableAppointments", availableAppointments);
//        return "available-appointments"; // Create a corresponding Thymeleaf template
//    }

	@GetMapping("/book-appointment/{patientId}")
	public String showAppointmentForm(@PathVariable Long patientId, Model model) {
		System.err.println(" @GetMapping(\"/book-appointment/{patientId}\") ----------------- START ");
		Patient patient = patientService.getPatientById(patientId)
				.orElseThrow(() -> new RuntimeException("Patient not found with id " + patientId));

		System.err.println("patient : --------> " + patient);
		model.addAttribute("patient", patient);
		model.addAttribute("patientId", patientId);
		System.err.println(" @GetMapping(\"/book-appointment/{patientId}\") ----------------- END ");
		return "book-appointment";
	}

	@PostMapping("/book-appointment/{patientId}")
	public String bookAppointment(@PathVariable Long patientId, @ModelAttribute Patient patient) {

		patient.setId(patientId);
		Long appointmentId = appointmentService.bookAppointment(patient);

		// Redirect to appropriate page after booking
		return "redirect:/patients"; // Redirect to patient list or other appropriate view
	}

	// Endpoint to approve an appointment
	@PostMapping("/appointments/{id}/approve")
	public String approveAppointment(@PathVariable Long id) {
		Patient patient = patientService.findById(id);
		if (patient != null) {
			patient.setAppointmentStatus("Approved");
			patientService.save(patient); // Save the updated status
		}
		return "redirect:/receptionists"; // Redirect to receptionist management page
	}

	// Endpoint to reject an appointment
	@PostMapping("/appointments/{id}/reject")
	public String rejectAppointment(@PathVariable Long id) {
		Patient patient = patientService.findById(id);
		if (patient != null) {
			patient.setAppointmentStatus("Rejected");
			patientService.save(patient); // Save the updated status
		}
		return "redirect:/receptionists"; // Redirect to receptionist management page
	}
}
