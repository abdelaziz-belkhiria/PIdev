package org.example.hospitalizationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class hospitalization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private LocalDateTime admissionDate;
    private LocalDateTime dischargeDate;
    private String roomNumber;
    private String admissionReason;
    private String status; // Replace with enum if needed
    private String userId;
    private String attendingDoctorId;
}