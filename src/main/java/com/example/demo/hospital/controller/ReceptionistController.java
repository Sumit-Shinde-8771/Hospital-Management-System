package com.example.demo.hospital.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.demo.hospital.entity.Receptionist;
//import com.example.demo.hospital.service.ReceptionistService;
//
//@Controller
//@RequestMapping("/receptionists")
//public class ReceptionistController {
//
//    @Autowired
//    private ReceptionistService receptionistService;
//
//    @GetMapping
//    public String getAllReceptionists(Model model) {
//        List<Receptionist> receptionists = receptionistService.getAllReceptionists();
//        model.addAttribute("receptionists", receptionists);
//        model.addAttribute("receptionist", new Receptionist()); // Add an empty receptionist object for form submission
//        return "receptionist"; // This maps to receptionist.html in src/main/resources/templates
//    }
//    @PostMapping
//    public String createReceptionist(@ModelAttribute Receptionist receptionist) {
//        receptionistService.saveReceptionist(receptionist);
//        return "redirect:/receptionists";
//    }
////    @PostMapping
////    public String saveReceptionist(@ModelAttribute Receptionist receptionist) {
////        receptionistService.saveReceptionist(receptionist);
////        return "redirect:/receptionists"; // Redirect to the receptionists list after saving
////    }
//
//    @GetMapping("/{id}")
//    public String getReceptionistById(@PathVariable Long id, Model model) {
//        Receptionist receptionist = receptionistService.getReceptionistById(id)
//                .orElseThrow(() -> new RuntimeException("Receptionist not found with id " + id));
//        model.addAttribute("receptionist", receptionist);
//        return "receptionist-details"; // Create receptionist-details.html for detailed view
//    }
//
//    @PostMapping("/{id}/update")
//    public String updateReceptionist(@PathVariable Long id, @ModelAttribute Receptionist receptionistDetails) {
//        receptionistService.updateReceptionist(id, receptionistDetails);
//        return "redirect:/receptionists"; // Redirect to GET /receptionists to refresh the list
//    }
//
//    @PostMapping("/{id}/delete")
//    public String deleteReceptionist(@PathVariable Long id) {
//        receptionistService.deleteReceptionist(id);
//        return "redirect:/receptionists"; // Redirect to GET /receptionists to refresh the list
//    }
//}

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.hospital.entity.Patient;
import com.example.demo.hospital.entity.Receptionist;
import com.example.demo.hospital.service.AppointmentService;
import com.example.demo.hospital.service.PatientService;
import com.example.demo.hospital.service.ReceptionistService;

@Controller
@RequestMapping("/receptionists")
public class ReceptionistController {
	
	private static final String REQUESTED = "REQUESTED";
    @Autowired
    private ReceptionistService receptionistService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllReceptionists( Model model) {
    	System.err.println("getAllReceptionists start->>>>>>>>>>>>>>>>>>.");
        List<Receptionist> receptionists = receptionistService.getAllReceptionists();
        List<Patient> patients = patientService.getPatientsByAppointmentStatus(REQUESTED);
        model.addAttribute("receptionists", receptionists);
        model.addAttribute("patients", patients);
        model.addAttribute("receptionist", new Receptionist());
        System.err.println("getAllReceptionists end->>>>>>>>>>>>>>>>>>.");
        return "receptionist";
    }

    @PostMapping
    public String createReceptionist(@ModelAttribute Receptionist receptionist) {
    	System.err.println("createReceptionist start->>>>>>>>>>>>>>>>>>.");
        receptionistService.saveReceptionist(receptionist);
        System.err.println("createReceptionist end->>>>>>>>>>>>>>>>>>.");
        return "redirect:/receptionists";
    }

    @GetMapping("/{id}/edit")
    public String getReceptionistById(@PathVariable Long id, Model model) {
        Optional<Receptionist> receptionist = receptionistService.getReceptionistById(id);
        model.addAttribute("receptionist", receptionist);
        return "receptionist-edit";
    }

    @PostMapping("/{id}/update")
    public String updateReceptionist(@PathVariable Long id, @ModelAttribute Receptionist receptionistDetails) {
        receptionistService.saveReceptionist(receptionistDetails);
        return "redirect:/receptionists";
    }

    @PostMapping("/{id}/delete")
    public String deleteReceptionist(@PathVariable Long id) {
        receptionistService.deleteReceptionist(id);
        return "redirect:/receptionists";
    }
// // Assuming it has methods to view, approve, and reject appointments
//    @GetMapping("/appointments")
//    public String getAllAppointments(Model model) {
//        List<Appointment> appointments = appointmentService.getAllAppointments();
//        model.addAttribute("appointments", appointments);
//        return "appointment-list"; // Assuming "appointment-list.html" displays appointment details
//    }
//
//    @PostMapping("/appointments/{id}/approve")
//    public String approveAppointment(@PathVariable Long id) {
//        Appointment appointment = appointmentService.getAppointmentById(id).orElseThrow();
//        appointment.setStatus(AppointmentStatus.CONFIRMED);
//        appointmentService.updateAppointment(appointment);
//        return "redirect:/receptionists/appointments";
//    }
//
//    @PostMapping("/appointments/{id}/reject")
//    public String rejectAppointment(@PathVariable Long id) {
//        Appointment appointment = appointmentService.getAppointmentById(id).orElseThrow();
//        appointment.setStatus(AppointmentStatus.CANCELLED);
//        appointmentService.updateAppointment(appointment);
//        return "redirect:/receptionists/appointments";
//    }

    
}

