package com.hospitalmanagementsystem.hospital_management_system.dto;

import com.hospitalmanagementsystem.hospital_management_system.entity.type.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodGroupCountResponseDTO {
    private BloodGroup bloodGroup;
    private Long count;
}
