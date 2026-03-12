package com.hospitalmanagementsystem.hospital_management_system.service;

import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public void getPatientByID(Long id){
        PatientTable p1=patientRepository.findById(id).orElseThrow();
        PatientTable p2=patientRepository.findById(id).orElseThrow();
        p1.setName("Hk");
    }

//    @Transactional
    public void savePatient(PatientTable p){
        patientRepository.save(p);
    }

    @Transactional
    public void updateBloodGroup(BloodGroup bloodGroup,  Long id){
        PatientTable patient1=patientRepository.findById(id).orElseThrow();
        patient1.setBloodGroup(bloodGroup);
        patientRepository.save(patient1);
        System.out.println(patient1);
    }

    public List<PatientTable> findByBloodGroup(BloodGroup bloodGroup){
        List<PatientTable> p=patientRepository.findByBloodGroup(bloodGroup);
        return p;
    }

    public PatientTable findByEmail(String email){
        return patientRepository.findByEmail(email);

    }

    public List<PatientTable> findByBornAfterBirthDate(LocalDate birthDate){
        return patientRepository.findByBornAfterDate(birthDate);
    }

    @Transactional
    public PatientTable updateMobileNumber(Long mobileNumber,Long id){
        PatientTable p=patientRepository.findById(id).orElseThrow();
        p.setMobileNumber(mobileNumber);
        patientRepository.save(p);
        return p;
    }

    public PatientTable findByMobileNumber(Long mobileNumber){
        return patientRepository.findByMobileNumber(mobileNumber);
    }

}
