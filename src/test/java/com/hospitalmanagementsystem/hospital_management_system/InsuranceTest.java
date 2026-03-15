package com.hospitalmanagementsystem.hospital_management_system;

import com.hospitalmanagementsystem.hospital_management_system.entity.Insurance;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;
import com.hospitalmanagementsystem.hospital_management_system.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientRepository patientRepository;

//    @Test
//    public void getPatientDetailsByInsurance(){
//        Insurance i=insuranceService.getPatientDetailsByInsurance(2L);
////        PatientTable p=i.getPatientTable();
//        System.out.println(i.getId());
//        System.out.println(i.getCreatedAt());
//        System.out.println(i.getPolicyNumber());
//        System.out.println(i.getValidUntil());
//        System.out.println(i.getVendor());
//        System.out.println(i.getPatientTable());
//        System.out.println();
//    }

@Test
    public void assignInsuranceToPatient(){
        Insurance insurance=new Insurance();
        insurance.setPolicyNumber("1234SAD");
        insurance.setValidUntil(LocalDate.of(2030,12,31));
        insurance.setVendor("HDFC");

        PatientTable patientTable =insuranceService.assignInsuranceToPatient(insurance,2L);

//        System.out.println(patient);

        System.out.println(patientTable.getId());
        System.out.println(patientTable.getMobileNumber());
        System.out.println(patientTable.getName());
        System.out.println(patientTable.getEmail());
        System.out.println(patientTable.getDob());
//        System.out.println(patient.getInsurance());

//    patient.setInsurance(null);
//    patientRepository.save(patient);
    }
}
