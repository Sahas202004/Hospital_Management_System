package com.hospitalmanagementsystem.hospital_management_system;

import com.hospitalmanagementsystem.hospital_management_system.dto.AppointmentDTO;
import com.hospitalmanagementsystem.hospital_management_system.entity.Appointment;
import com.hospitalmanagementsystem.hospital_management_system.repo.AppointmentRepository;
import com.hospitalmanagementsystem.hospital_management_system.service.AppointmentService;
import jakarta.transaction.Transactional;
import net.bytebuddy.asm.Advice;
import org.hibernate.sql.ast.tree.update.Assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Test
    public void assignAppointment(){
//        Appointment appointment=appointmentService.assignAppointment(3L,1L,"Neurology", LocalDateTime.of(2026,4,3,2,10));
//        System.out.println("Appointment Booked Successfully");
//        System.out.println(appointment.toString());

        Appointment appointment= Appointment.builder()
                .reason("Cardiology")
                .time(LocalDateTime.of(2026,4,12,10,0))
                .build();

        Appointment newAppointment=appointmentService.assignAppointment(appointment,5L,2L," Dermatology");
        appointmentRepository.save(newAppointment);
        System.out.println("Appointment Created");
    }

    @Test
    public void deleteAppointmentById(){
        appointmentRepository.deleteById(8L);
        System.out.println("AppointmentDeletedSuccessfully");
    }

    @Test
    public void reAssignDoctorToAppointment(){
        appointmentService.reassignAppointment(4L,5L);
//        appointmentRepository.save(appointment);
        System.out.println("Appointment Updated Successfully");
    }

    @Test
    public void getAssignmentDetails(){
        AppointmentDTO appointment=appointmentService.getAppointmentInformation(7L);
        System.out.println(appointment);
    }

}
