//package com.example.demo.hospital.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.hospital.entity.Appointment;
//
//@Repository
//public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    
//    // Custom query method to find available appointments for a specific doctor
//    List<Appointment> findByDoctorIdAndAvailableTrue(Long doctorId);
//
//    // Custom query method to find all appointments for a specific doctor
//    List<Appointment> findByDoctorId(Long doctorId);
//
//    // Custom query method to find all appointments for a specific patient
//    List<Appointment> findByPatientId(Long patientId);
//}
//  
package com.example.demo.hospital.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.hospital.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Appointment save(Appointment appointment);
//	  public static List<LocalDateTime> findAvailableAppointmentsForNextWeek() {
//	        LocalDateTime now = LocalDateTime.now();
//	        LocalDateTime endOfWeek = now.plusDays(7).with(LocalTime.of(20, 0)); // End of 7 days at 8 pm
//
//	        // Adjust start time to 9 am on the current day
//	        LocalDateTime currentDayStartTime = now.with(LocalTime.of(9, 0));
//	        LocalDateTime currentDayEndTime = now.with(LocalTime.of(20, 0)); // 8 pm
//
//	        List<LocalDateTime> availableAppointments = new ArrayList<>();
//
//	        LocalDateTime appointmentTime = currentDayStartTime;
//
//	        while (appointmentTime.isBefore(endOfWeek)) {
//	            // Check if it's within working hours (9 am to 8 pm)
//	            if (appointmentTime.isBefore(currentDayEndTime) && appointmentTime.isAfter(currentDayStartTime)) {
//	                availableAppointments.add(appointmentTime);
//	            }
//	            // Move to next potential appointment slot after lunch break
//	            appointmentTime = appointmentTime.plusMinutes(30); // Lunch break
//	            if (appointmentTime.toLocalTime().equals(LocalTime.of(13, 0))) { // Lunch break at 1 pm
//	                appointmentTime = appointmentTime.plusMinutes(30); // Resume at 1:30 pm
//	            }
//	        }
//
//	        return availableAppointments;
//	    }
}
