package com.example.demo.hospital.repository;


import com.example.demo.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDeletedFalse();
    List<Patient> getByAppointmentStatus(String status);
}
