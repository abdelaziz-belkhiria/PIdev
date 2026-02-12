package entity;
import entity.Enumerations.PrescriptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate prescriptionDate;

    @Enumerated(EnumType.STRING)
    private PrescriptionStatus status;

    private LocalDate validUntil;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    private String consultationId;

    private String userId;

    private String prescribedBy;


    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<Medication> medications;
}
