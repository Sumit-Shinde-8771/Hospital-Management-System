//package com.example.demo.hospital.entity;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    private Doctor doctor;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    private Patient patient;
//
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//
//    private boolean available;
//
//    // Default constructor
//  //  public Appointment(Optional<Doctor> doctor2, LocalDateTime appointmentTime, LocalDateTime endAppointmentTime, boolean b) {}
//
//    // Constructor
//    public Appointment(Doctor doctor, LocalDateTime startTime, LocalDateTime endTime,boolean available) {
//        this.doctor = doctor;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.available = available;
//    }
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public LocalDateTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(LocalDateTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalDateTime getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(LocalDateTime endTime) {
//        this.endTime = endTime;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//}
package com.example.demo.hospital.entity;
//
//import java.time.LocalDateTime;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "appointments")
//public class Appointment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id", nullable = false)
//    private Patient patient;
//
//    @ManyToOne
//    @JoinColumn(name = "doctor_id", nullable = false)
//    private Doctor doctor;
//
//    @ManyToOne
//    @JoinColumn(name = "receptionist_id")
//    private Receptionist receptionist;
//
//    @Column(nullable = false)
//    private LocalDateTime appointmentDateTime;
//
//    @Enumerated(EnumType.STRING)
//    private AppointmentStatus status;
//
//    // Constructors, getters, and setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public Receptionist getReceptionist() {
//        return receptionist;
//    }
//
//    public void setReceptionist(Receptionist receptionist) {
//        this.receptionist = receptionist;
//    }
//
//    public LocalDateTime getAppointmentDateTime() {
//        return appointmentDateTime;
//    }
//
//    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
//        this.appointmentDateTime = appointmentDateTime;
//    }
//
//    public AppointmentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AppointmentStatus status) {
//        this.status = status;
//    }
//
//	
//}

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    private String appointmentDate;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;

    // Getters and Setters
}

