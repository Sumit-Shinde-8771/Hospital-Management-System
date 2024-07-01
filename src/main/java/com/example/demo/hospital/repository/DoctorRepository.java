package com.example.demo.hospital.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.example.demo.hospital.entity.Doctor;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    List<Doctor> findByDeletedFalse();
//}

import com.example.demo.hospital.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//	 @Query("SELECT d FROM Doctor d WHERE d.deleted = false")
    List<Doctor> findByDeletedFalse();
//	 Optional<Doctor> findById(Long id);
//	
}
