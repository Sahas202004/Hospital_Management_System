package com.hospitalmanagementsystem.hospital_management_system.controller;

import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/EnterPatient")
    public void enterPatient(@RequestBody PatientTable p){
        patientService.savePatient(p);
    }

}
