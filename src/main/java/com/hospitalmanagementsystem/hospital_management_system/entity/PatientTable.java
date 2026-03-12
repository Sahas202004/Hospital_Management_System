package com.hospitalmanagementsystem.hospital_management_system.entity;

import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
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
@Table(
        name = "PatientTable",
        uniqueConstraints = {
                @UniqueConstraint(name="UniqueEmailAndName",columnNames = {"email","name"}),
                @UniqueConstraint(name="UniqueContactNumberAndName",columnNames = {"name","mobileNumber"})
        },
        indexes = {
                @Index(name="email_Index",columnList = "email")
        }
)
public class PatientTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(updatable = false,nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false,unique = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodGroup bloodGroup;

    @Column(nullable = false)
    private Long mobileNumber;
}
