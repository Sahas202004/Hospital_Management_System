package com.hospitalmanagementsystem.hospital_management_system.repo;

import com.hospitalmanagementsystem.hospital_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
