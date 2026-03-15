package com.hospitalmanagementsystem.hospital_management_system.service;

import com.hospitalmanagementsystem.hospital_management_system.entity.Insurance;
import com.hospitalmanagementsystem.hospital_management_system.repo.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public Insurance getPatientDetailsByInsurance(Long id){
        return insuranceRepository.findById(id).orElseThrow();
    }
}
