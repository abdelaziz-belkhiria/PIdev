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
public class VitalSigns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private LocalDateTime recordDate;
    private Float temperature;
    private String bloodPressure;
    private Integer heartRate;
    private Integer respiratoryRate;
    private Float oxygenSaturation;
    private String notes;
    private String hospitalizationId;
    private String recordedBy;
}