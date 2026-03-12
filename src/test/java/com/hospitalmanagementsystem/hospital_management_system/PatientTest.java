package com.hospitalmanagementsystem.hospital_management_system;

//import com.hospitalmanagementsystem.hospital_management_system.entity.Patient;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;
import com.hospitalmanagementsystem.hospital_management_system.service.PatientService;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void getAllPatients(){
        List<PatientTable> patients=patientRepository.findAll();
        for(PatientTable p:patients){
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDob());
            System.out.println(p.getGender());
            System.out.println(p.getEmail());
            System.out.println(p.getCreateDate());
            System.out.println();
        }
    }

    @Test
    public void getPatientByID(){
        patientService.getPatientByID(1L);
    }

    @Test
    public void savePatient(){
        PatientTable p=new PatientTable();
        p.setName("Pooja");
//        p.setId(1L);
        p.setDob(LocalDate.of(1994,1,21));
        p.setGender("Female");
        p.setEmail("poojakshirsagar123@gmail.com");
        p.setMobileNumber(9146635353L);
        p.setBloodGroup(BloodGroup.AB_Positive);
        patientService.savePatient(p);
    }

    @Test
    public void updateBloodGroup(){
        patientService.updateBloodGroup(BloodGroup.AB_Positive,3L);
    }

    @Test
    public void findByBloodGroup(){
        List<PatientTable> l=patientService.findByBloodGroup(BloodGroup.B_Positive);
        for(PatientTable p:l){
            System.out.println(p.toString());
        }
    }

    @Test
    public void findByEmail(){
        System.out.println(patientService.findByEmail("sk123@gmail.com"));
    }

    @Test
    public void findByBornAfterBirthDate(){
        List<PatientTable> p=patientService.findByBornAfterBirthDate(LocalDate.of(1999,10,2));
        for(PatientTable p1:p){
            System.out.println(p1.toString());
        }
    }

    @Test
    public void updateMobileNumber(){
        PatientTable p=patientService.updateMobileNumber(9146635353L,3L);
        System.out.println(p.toString());
    }

    @Test
    public void findByMobileNumber(){
        System.out.println(patientService.findByMobileNumber(9356960113L));
    }
}
