package com.example.demo.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.hospital.entity.Patient;
import com.example.demo.hospital.service.AppointmentService;
import com.example.demo.hospital.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        model.addAttribute("patient", new Patient()); // Add an empty patient object for form submission
        return "patient"; // This maps to patient.html in src/main/resources/templates
    }

    @PostMapping
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients"; // Redirect to GET /patients to refresh the list
    }

    @GetMapping("/{id}/edit")
    public String getPatientById(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        model.addAttribute("patient", patient);
        return "patient-edit"; // Create patient-edit.html for editing
    }

    @PostMapping("/{id}/update")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patientDetails) {
        patientService.updatePatient(id, patientDetails);
        return "redirect:/patients"; // Redirect to GET /patients to refresh the list
    }

    @PostMapping("/{id}/delete")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients"; // Redirect to GET /patients to refresh the list
    }

    @GetMapping("/{id}")
    public String viewPatientById(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
        model.addAttribute("patient", patient);
        return "view-patient"; // This maps to view-patient.html
    }

//    @PostMapping("/{id}/request")
//    public String requestAppointment(@PathVariable("id") Long patientId, RedirectAttributes redirectAttributes) {
//        // Logic to process appointment request
//        // Redirect to the booking form or appropriate view
//        return "redirect:/book-appointment"; // Redirect to booking form
//    }
    @PostMapping("/{id}/request")
    public String requestAppointment(@PathVariable("id") Long patientId, RedirectAttributes redirectAttributes) {
    	 redirectAttributes.addAttribute("patientId", patientId);
        return "redirect:/book-appointment/{patientId}"; // Redirect to booking form
    }
}
