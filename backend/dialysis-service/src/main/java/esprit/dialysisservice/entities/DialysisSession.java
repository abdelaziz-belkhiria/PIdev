package esprit.dialysisservice.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "dialysis_sessions")
public class DialysisSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Relationship: One Treatment -> Many Sessions
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", nullable = false)
    private DialysisTreatment treatment;

    // External Keys
    private UUID nurseId; // Who performed it

    private LocalDateTime sessionDate;

    // Machine Data (Physical Inputs)
    private Double weightBefore;
    private Double weightAfter;
    private Double ultrafiltrationVolume; // Liters removed

    // Safety Data
    private String preBloodPressure; // "120/80"
    private String complications;    // Text description

    // Math Data (To be calculated in Level 2)
    // We store them as null initially
    private Double preDialysisUrea;  // From Lab
    private Double postDialysisUrea; // From Lab
    private Double achievedKtV;      // The Result
}