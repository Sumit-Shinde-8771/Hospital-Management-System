package com.example.demo.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.demo.hospital.entity.Doctor;
//import com.example.demo.hospital.repository.DoctorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DoctorService {
//
//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    public List<Doctor> getAllDoctors() {
//        return doctorRepository.findAll();
//    }
//
//    public Optional<Doctor> getDoctorById(Long id) {
//        return doctorRepository.findById(id);
//    }
//
//    @Transactional
//    public Doctor createDoctor(Doctor doctor) {
//        doctor.setDeleted(false); // Ensure the deleted field is set to false
//        return doctorRepository.save(doctor);
//    }
//
//    @Transactional
//    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
//        Doctor doctor = doctorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//        doctor.setName(doctorDetails.getName());
//        doctor.setSpecialization(doctorDetails.getSpecialization());
//        return doctorRepository.save(doctor);
//    }
//
//    @Transactional
//    public void deleteDoctor(Long id) {
//        Doctor doctor = doctorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//        doctor.setDeleted(true);
//        doctorRepository.save(doctor);
//    }
//}



import com.example.demo.hospital.entity.Doctor;
import com.example.demo.hospital.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findByDeletedFalse();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @Transactional
    public Doctor createDoctor(Doctor doctor) {
        doctor.setDeleted(false); // Ensure the deleted field is set to false
        return doctorRepository.save(doctor);
    }

//    @Transactional
//    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
//        Doctor doctor = doctorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//        doctor.setName(doctorDetails.getName());
//        doctor.setSpecialization(doctorDetails.getSpecialization());
//        return doctorRepository.save(doctor);
//    }

    @Transactional
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
        doctor.setDeleted(true);
        doctorRepository.save(doctor);
    }
    @Transactional
    public Doctor updateDoctor(Doctor doctor) {
        // Check if doctor exists
        Doctor existingDoctor = doctorRepository.findById(doctor.getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctor.getId()));

        // Update fields
        existingDoctor.setName(doctor.getName());
        existingDoctor.setSpecialization(doctor.getSpecialization());

        // Save and return updated doctor
        return doctorRepository.save(existingDoctor);
    }
//    @Transactional
//    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
//        Doctor doctor = doctorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
//
//        // Update properties
//        doctor.setName(doctorDetails.getName());
//        doctor.setSpecialization(doctorDetails.getSpecialization());
//
//        return doctorRepository.save(doctor);
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        return doctorRepository.save(doctor);
    }
    
}

