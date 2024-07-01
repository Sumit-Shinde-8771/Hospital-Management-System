package com.example.demo.hospital.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.example.demo.hospital.entity.Appointment;
//import com.example.demo.hospital.entity.Patient;
//import com.example.demo.hospital.repository.AppointmentRepository;
//
//import ch.qos.logback.core.model.Model;
//
//@Service
//public class AppointmentService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    public List<Appointment> getAllAppointments() {
//        return appointmentRepository.findAll();
//    }
//
//    public Optional<Appointment> getAppointmentById(Long id) {
//        return appointmentRepository.findById(id);
//    }
//
//    public void createAppointment(Appointment appointment) {
//        appointmentRepository.save(appointment);
//    }
//
//    public void updateAppointment(Appointment appointment) {
//        appointmentRepository.save(appointment);
//    }
//
//    public void deleteAppointment(Long id) {
//        appointmentRepository.deleteById(id);
//    }
//    public void updateAppointment(Long id, Appointment updatedAppointment) {
//        Appointment appointment = appointmentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
//
//        appointment.setPatient(updatedAppointment.getPatient());
//        appointment.setDoctor(updatedAppointment.getDoctor());
//        appointment.setReceptionist(updatedAppointment.getReceptionist());
//        appointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
//        appointment.setStatus(updatedAppointment.getStatus());
//
//        appointmentRepository.save(appointment);
//    }
//  
//    public Long bookAppointment(Patient patient) {
//        // Logic to book the appointment and return the appointment ID
//        // Replace this with your actual logic to save appointment details and return the ID
//        return 12345L; // Example appointment ID
//    }
//
//    // Additional methods as needed
//}
//
//

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hospital.entity.Appointment;
import com.example.demo.hospital.entity.Patient;
import com.example.demo.hospital.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public void requestAppointment(Patient patient, String appointmentDate) {
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setStatus("Pending");
        appointmentRepository.save(appointment);
    }

    public void updateStatus(Long id, String status) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }
    public Long bookAppointment(Patient patient) {
        // Replace this with your actual logic to save appointment details and return the ID
        // Example:
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setStatus("Pending"); // Assuming initial status
        appointmentRepository.save(appointment);
        
        return appointment.getId(); // Adjust this based on your actual implementation
    }

}

