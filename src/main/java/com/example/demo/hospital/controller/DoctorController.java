package com.example.demo.hospital.controller;

//
//
//import com.example.demo.hospital.entity.Doctor;
//import com.example.demo.hospital.service.DoctorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/doctors")
//public class DoctorController {
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @GetMapping
//    public String getAllDoctors(Model model) {
//        List<Doctor> doctors = doctorService.getAllDoctors();
//        model.addAttribute("doctors", doctors);
//        model.addAttribute("doctor", new Doctor()); // Add an empty doctor object for form submission
//        return "doctor"; // This maps to doctor.html in src/main/resources/templates
//    }
//
//    @PostMapping
//    public String createDoctor(@ModelAttribute Doctor doctor) {
//        doctorService.createDoctor(doctor);
//        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
//    }
//
//    @GetMapping("/{id}")
//    public String getDoctorById(@PathVariable Long id, Model model) {
//        Doctor doctor = doctorService.getDoctorById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//        model.addAttribute("doctor", doctor);
//        return "doctor-details"; // Create doctor-details.html for detailed view
//    }
//
//    @PostMapping("/{id}/update")
//    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctorDetails) {
//        doctorService.updateDoctor(id, doctorDetails);
//        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
//    }
//
//    @PostMapping("/{id}/delete")
//    public String deleteDoctor(@PathVariable Long id) {
//        doctorService.deleteDoctor(id);
//        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
//    }
//}...


import com.example.demo.hospital.entity.Doctor;
import com.example.demo.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public String getAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        model.addAttribute("doctor", new Doctor()); // Add an empty doctor object for form submission
        return "doctor"; // This maps to doctor.html in src/main/resources/templates
    }

    @PostMapping
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorService.createDoctor(doctor);
        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
    }

    @GetMapping("/{id}/edit")
    public String getDoctorById(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
        model.addAttribute("doctor", doctor);
        return "doctor-edit"; // Create edit-doctor.html for editing
    }

//    @PostMapping("/{id}/update")
//    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctorDetails) {
//        doctorService.updateDoctor(id, doctorDetails);
//        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
//    }
    public String editDoctorForm(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        model.addAttribute("doctor", doctor);
        return "doctor-edit"; // Ensure your HTML file name matches
    }

    // Mapping for submitting the edited doctor form
    @PostMapping("/{id}/update")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctorDetails) {
        doctorService.updateDoctor(id, doctorDetails);
        return "redirect:/doctors";
    }

    
    @PostMapping("/{id}/delete")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors"; // Redirect to GET /doctors to refresh the list
    }

    @GetMapping("/{id}")
    public String viewDoctorById(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
        model.addAttribute("doctor", doctor);
        return "view-doctor"; // This maps to view-doctor.html
    }
//    @GetMapping("/{id}/edit")
//    public String editDoctor(@PathVariable Long id, Model model) {
//        Doctor doctor = doctorService.getDoctorById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//        model.addAttribute("doctor", doctor);
//        return "edit-doctor"; // Assuming edit-doctor.html is your edit template
//    }
}

