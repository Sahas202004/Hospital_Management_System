package com.hospitalmanagementsystem.hospital_management_system.repo;


import com.hospitalmanagementsystem.hospital_management_system.dto.BloodGroupCountResponseDTO;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientTable,Long> {
    List<PatientTable> findByBloodGroup(BloodGroup bloodGroup);

    PatientTable findByEmail(String email);

    @Query("Select p from PatientTable p where p.dob > :dob1")
    List<PatientTable> findByBornAfterDate(@Param("dob1")LocalDate birthDate);


    PatientTable findByMobileNumber(Long mobileNumber);

    @Query("select p.bloodGroup, Count(p) from PatientTable p where p.bloodGroup is not null group by p.bloodGroup")
    List<Object[]> findEachBloodGroupType();

    @Query(value = "select * from patient_table",nativeQuery = true)
    List<PatientTable> findAllPatients();

    @Transactional
    @Modifying
    @Query("Update PatientTable p set p.name=:name where p.id=:id")
    int updateName(@Param("name") String name,@Param("id") Long id);

    @Query("select new com.hospitalmanagementsystem.hospital_management_system.dto.BloodGroupCountResponseDTO" +
            "(p.bloodGroup,Count(p)) from PatientTable p group by p.bloodGroup")
    List<BloodGroupCountResponseDTO> countPatientByBloodGroup();

    @Query(value = "Select * from Patient_Table",nativeQuery = true)
    Page<PatientTable> findAllPageable(Pageable pageable);

}
