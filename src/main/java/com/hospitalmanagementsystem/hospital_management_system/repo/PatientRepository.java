package com.hospitalmanagementsystem.hospital_management_system.repo;


import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientTable,Long> {
    List<PatientTable> findByBloodGroup(BloodGroup bloodGroup);

    PatientTable findByEmail(String email);

    @Query("Select p from PatientTable p where p.dob > :dob1")
    List<PatientTable> findByBornAfterDate(@Param("dob1")LocalDate birthDate);


    PatientTable findByMobileNumber(Long mobileNumber);
}
