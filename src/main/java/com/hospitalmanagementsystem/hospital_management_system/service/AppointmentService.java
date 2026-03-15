package com.hospitalmanagementsystem.hospital_management_system.service;

import com.hospitalmanagementsystem.hospital_management_system.dto.AppointmentDTO;
import com.hospitalmanagementsystem.hospital_management_system.entity.Appointment;
import com.hospitalmanagementsystem.hospital_management_system.entity.Doctor;
import com.hospitalmanagementsystem.hospital_management_system.entity.PatientTable;
import com.hospitalmanagementsystem.hospital_management_system.repo.AppointmentRepository;
import com.hospitalmanagementsystem.hospital_management_system.repo.DoctorRepository;
import com.hospitalmanagementsystem.hospital_management_system.repo.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;


    @Transactional
    public Appointment assignAppointment(Appointment appointment,Long patientId, Long doctorId, String reason){
        PatientTable patientTable =patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("Patient with ID:"+patientId+" not Found!"));
        Doctor doctor=doctorRepository.findById(doctorId)
                .orElseThrow(()->new EntityNotFoundException("Doctor with ID:"+doctorId+" not Found!"));

       appointment.setDoctor(doctor);
       appointment.setPatientTable(patientTable);


        patientTable.getAppointment().add(appointment); // just to maintain bi-directional consistency
        doctor.getAppointments().add(appointment);

        return appointment;
    }

    @Transactional
    public Appointment reassignAppointment(Long appointmentId,Long newDoctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(newDoctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return appointment;
    }

    @Transactional
    public AppointmentDTO getAppointmentInformation(Long appointmentId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();

        AppointmentDTO appointmentDTO=new AppointmentDTO();
        appointmentDTO.setAppointmentId(appointment.getId());
        appointmentDTO.setPatientName(appointment.getPatientTable().getName());
        appointmentDTO.setDoctorName(appointment.getDoctor().getName());
        appointmentDTO.setReason(appointment.getReason());
        appointmentDTO.setTime(appointment.getTime());

        return appointmentDTO;
    }
}
