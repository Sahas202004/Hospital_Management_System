package com.hospitalmanagementsystem.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String vendor;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate createdAt;

    @OneToOne(mappedBy = "insurance") // inverse Side
    private PatientTable patientTable;
}
