package com.hospitalmanagementsystem.hospital_management_system.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    Long appointmentId;
    String patientName;
    String doctorName;
    LocalDateTime time;
    String reason;
}
