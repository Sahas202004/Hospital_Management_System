package com.hospitalmanagementsystem.hospital_management_system.repo;

import com.hospitalmanagementsystem.hospital_management_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
