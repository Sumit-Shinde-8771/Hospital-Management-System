package com.example.demo.hospital.service;
//

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.ui.Model;
//
//
//import com.example.demo.hospital.entity.Patient;
//import com.example.demo.hospital.repository.PatientRepository;
//
//import jakarta.servlet.http.HttpSession;
//
//@Service
//public class PatientService {
//
//    @Autowired
//    private PatientRepository patientRepository;
//    private AppointmentService appointmentService;
//
//    public List<Patient> getAllPatients() {
//        return patientRepository.findAll();
//    }
//
//    public void createPatient(Patient patient) {
//        patientRepository.save(patient);
//    }
//
//    public Optional<Patient> getPatientById(Long id) {
//        return patientRepository.findById(id);
//    }
//
//    public void updatePatient(Long id, Patient patientDetails) {
//        Patient patient = patientRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
//        patient.setName(patientDetails.getName());
//        patient.setAge(patientDetails.getAge());
//        patient.setDisease(patientDetails.getDisease());
//        patientRepository.save(patient);
//    }
//
//    public void deletePatient(Long id) {
//        patientRepository.deleteById(id);
//    }
//    public List<String> getAvailableSlots() {
//        List<String> availableSlots = new ArrayList<>();
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime start = now.withHour(9).withMinute(0).withSecond(0).withNano(0);
//
//        for (int day = 0; day < 7; day++) {
//            LocalDateTime date = start.plusDays(day);
//            for (int hour = 9; hour < 20; hour++) {
//                for (int minute = 0; minute < 60; minute += 30) {
//                    LocalDateTime slot = date.withHour(hour).withMinute(minute);
//                    availableSlots.add(slot.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
//                }
//            }
//        }
//        return availableSlots;
//    }
//
////    @GetMapping("/appointment")
////    public String showAppointmentForm(Model model) {
////        model.addAttribute("patient", new Patient());
////        return "appointment-form";
////    }
////
////    @PostMapping("/appointment/book")
////    public String bookAppointment(@ModelAttribute Patient patient, HttpSession session) {
////        // Save patient details in session for receptionist view
////        session.setAttribute("patientName", patient.getName());
////        session.setAttribute("patientAge", patient.getAge());
////        session.setAttribute("patientDisease", patient.getDisease());
////
////        // Book appointment logic
////        // Assuming appointmentService.bookAppointment(patient) returns the appointment ID
////        Long appointmentId = appointmentService.bookAppointment(patient);
////
////        // Clear patient details from session after booking
////        session.removeAttribute("patientName");
////        session.removeAttribute("patientAge");
////        session.removeAttribute("patientDisease");
////
////        return "redirect:/patients/appointment/success";
////    }
//    public Patient findById(Long id) {
//        return patientRepository.findById(id).orElse(null);
//
//   
//    
//}
//}

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hospital.entity.Doctor;
import com.example.demo.hospital.entity.Patient;
import com.example.demo.hospital.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentService appointmentService;

//  @Autowired
//  private PatientRepository patientRepository;
//  private AppointmentService appointmentService;
//
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

//  public void createPatient(Patient patient) {
//      patientRepository.save(patient);
//  }

	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	public void updatePatient(Long id, Patient patientDetails) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
		patient.setName(patientDetails.getName());
		patient.setAge(patientDetails.getAge());
		patient.setDisease(patientDetails.getDisease());
		patientRepository.save(patient);
	}

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}

	public Patient findById(Long id) {
		return patientRepository.findById(id).orElse(null);
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	public Long bookAppointment(Patient patient) {
		// Here you would have logic to book the appointment and return the appointment
		// ID
		// Example:
		Long appointmentId = appointmentService.bookAppointment(patient); // Adjust this based on your actual
																			// implementation
		return appointmentId;
	}

	@Transactional
	public Patient createPatient(Patient patient) {
		patient.setDeleted(false); // Ensure the deleted field is set to false
		return patientRepository.save(patient);
	}

	public List<Patient> getPatientsByAppointmentStatus(String status) {
		return patientRepository.getByAppointmentStatus(status);
	}

}

//@Transactional
//public Pa updateDoctor(Long id, Doctor doctorDetails) {
//    Doctor doctor = doctorRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//    doctor.setName(doctorDetails.getName());
//    doctor.setSpecialization(doctorDetails.getSpecialization());
//    return doctorRepository.save(doctor);
//}

//@Transactional
//public void deleteDoctor(Long id) {
//    Doctor doctor = doctorRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//    doctor.setDeleted(true);
//    doctorRepository.save(doctor);
//}
//@Transactional
//public Doctor updateDoctor(Doctor doctor) {
//    // Check if doctor exists
//    Doctor existingDoctor = doctorRepository.findById(doctor.getId())
//            .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctor.getId()));
//
//    // Update fields
//    existingDoctor.setName(doctor.getName());
//    existingDoctor.setSpecialization(doctor.getSpecialization());
//
//    // Save and return updated doctor
//    return doctorRepository.save(existingDoctor);
//}
////@Transactional
////public Doctor updateDoctor(Long id, Doctor doctorDetails) {
////    Doctor doctor = doctorRepository.findById(id)
////            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
////
////    // Update properties
////    doctor.setName(doctorDetails.getName());
////    doctor.setSpecialization(doctorDetails.getSpecialization());
////
////    return doctorRepository.save(doctor);
//public Doctor updateDoctor(Long id, Doctor doctorDetails) {
//    Doctor doctor = doctorRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//    doctor.setName(doctorDetails.getName());
//    doctor.setSpecialization(doctorDetails.getSpecialization());
//    return doctorRepository.save(doctor);
//}
