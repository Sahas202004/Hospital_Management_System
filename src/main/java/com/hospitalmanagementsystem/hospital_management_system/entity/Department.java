package com.hospitalmanagementsystem.hospital_management_system.entity;

import jakarta.persistence.*;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "head_doctor_id") // owning side
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dpt_doctor",
            joinColumns = @JoinColumn(name="department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctors_id")
    )
    private Set<Doctor> doctors=new HashSet<>();
}
