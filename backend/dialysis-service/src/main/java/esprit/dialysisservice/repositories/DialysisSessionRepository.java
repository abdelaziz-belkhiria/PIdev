package esprit.dialysisservice.repositories;

import esprit.dialysisservice.entities.DialysisSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DialysisSessionRepository extends JpaRepository<DialysisSession, UUID> {
    // Get history for a specific treatment plan
    List<DialysisSession> findByTreatmentId(UUID treatmentId);
}