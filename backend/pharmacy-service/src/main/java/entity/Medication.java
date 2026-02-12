package entity;

import entity.Enumerations.MedicationRoute;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String medicationName;
    private String dosage;
    private Integer frequency;

    @Enumerated(EnumType.STRING)
    private MedicationRoute route;

    private Integer duration;
    private Integer quantity;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
}
