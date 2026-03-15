package com.hospitalmanagementsystem.hospital_management_system.repo;

import com.hospitalmanagementsystem.hospital_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
