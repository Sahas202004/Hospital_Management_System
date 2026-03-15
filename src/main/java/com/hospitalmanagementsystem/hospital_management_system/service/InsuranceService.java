package com.hospitalmanagementsystem.hospital_management_system.service;

import com.hospitalmanagementsystem.hospital_management_system.entity.Insurance;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.repo.InsuranceRepository;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private PatientRepository patientRepository;
//
//    public Insurance getPatientDetailsByInsurance(Long id){
//        return insuranceRepository.findById(id).orElseThrow();
//    }

    @Transactional
    public PatientTable assignInsuranceToPatient(Insurance insurance, Long patientId){
        PatientTable patientTable =patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id:"+patientId+" not found"));
        patientTable.setInsurance(insurance);
        insurance.setPatientTable(patientTable);
        patientRepository.save(patientTable);

        return patientTable;
    }

}
