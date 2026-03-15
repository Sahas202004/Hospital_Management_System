package com.hospitalmanagementsystem.hospital_management_system.service;

import com.hospitalmanagementsystem.hospital_management_system.repo.InsuranceRepository;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;

//
//    @Transactional
//    public void getPatientByID(Long id){
//        PatientTable p1=patientRepository.findById(id).orElseThrow();
//        PatientTable p2=patientRepository.findById(id).orElseThrow();
//        p1.setName("Hk");
//    }
//
////    @Transactional
//    public void savePatient(PatientTable p){
//        patientRepository.save(p);
//    }
//
//    @Transactional
//    public void updateBloodGroup(BloodGroup bloodGroup,  Long id){
//        PatientTable patient1=patientRepository.findById(id).orElseThrow();
//        patient1.setBloodGroup(bloodGroup);
//        patientRepository.save(patient1);
//        System.out.println(patient1);
//    }
//
//    public List<PatientTable> findByBloodGroup(BloodGroup bloodGroup){
//        List<PatientTable> p=patientRepository.findByBloodGroup(bloodGroup);
//        return p;
//    }
//
//    public PatientTable findByEmail(String email){
//        return patientRepository.findByEmail(email);
//
//    }
//
//    public List<PatientTable> findByBornAfterBirthDate(LocalDate birthDate){
//        return patientRepository.findByBornAfterDate(birthDate);
//    }
//
//    @Transactional
//    public PatientTable updateMobileNumber(Long mobileNumber,Long id){
//        PatientTable p=patientRepository.findById(id).orElseThrow();
//        p.setMobileNumber(mobileNumber);
//        patientRepository.save(p);
//        return p;
//    }
//
//    public PatientTable findByMobileNumber(Long mobileNumber){
//        return patientRepository.findByMobileNumber(mobileNumber);
//    }
//
//    public List<Object[]> getCountByBloodGroup(){
//        return patientRepository.findEachBloodGroupType();
//    }
//
//    public List<PatientTable> findAllPatients(){
//        return patientRepository.findAllPatients();
//    }
//
//
//    public int updateName(String name,Long id){
//        return patientRepository.updateName(name,id);
//    }
//
//    public List<BloodGroupCountResponseDTO> countPatientsByBloodGroup(){
//        return patientRepository.countPatientByBloodGroup();
//    }
//
//    public Page<PatientTable> findAllPageable(Pageable pageable){
//        return patientRepository.findAllPageable(pageable);
//    }




}
