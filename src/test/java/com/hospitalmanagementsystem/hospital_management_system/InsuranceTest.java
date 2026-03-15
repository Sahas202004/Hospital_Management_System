package com.hospitalmanagementsystem.hospital_management_system;

import com.hospitalmanagementsystem.hospital_management_system.entity.Insurance;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

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
}
