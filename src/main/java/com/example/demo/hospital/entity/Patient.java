package com.example.demo.hospital.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "patients")
//public class Patient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    private String name;
//    
//    private int age;
//
//    // Constructors, getters, and setters
//
//    public Patient() {
//    }
//
//    public Patient(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;
    private int age;
    private String disease;
    private boolean deleted = false;
    private String appointmentStatus = "PENDING";
    
    @OneToOne
    private Receptionist receptionist;
    // Default constructor
    public Patient() {
    }

    // Custom constructor
    public Patient(String name, int age, String disease, Long doctorId) {
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    // Getters and setters
    public Long getId() {
        return patient_id;
    }

    public void setId(Long id) {
        this.patient_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", name=" + name + ", age=" + age + ", disease=" + disease
				+ ", deleted=" + deleted + ", appointmentStatus=" + appointmentStatus + ", receptionist=" + receptionist
				+ "]";
	}

 
}
