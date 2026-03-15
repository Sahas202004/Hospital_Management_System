package com.hospitalmanagementsystem.hospital_management_system.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false,length = 100)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false) // owning side
    private PatientTable patientTable;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false) // owning side
    private Doctor doctor;

}
