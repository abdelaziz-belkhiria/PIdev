package esprit.dialysisservice.services;

import esprit.dialysisservice.entities.DialysisSession;
import esprit.dialysisservice.entities.DialysisTreatment;
import esprit.dialysisservice.repositories.DialysisSessionRepository;
import esprit.dialysisservice.repositories.DialysisTreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DialysisSessionServiceImpl implements IDialysisSessionService {

    private final DialysisSessionRepository sessionRepository;
    private final DialysisTreatmentRepository treatmentRepository;

    @Override
    public DialysisSession startSession(UUID treatmentId, Double weightBefore, UUID nurseId) {
        // We must fetch the parent Treatment first
        DialysisTreatment treatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(() -> new RuntimeException("Treatment Plan not found"));

        DialysisSession session = DialysisSession.builder()
                .treatment(treatment) // Link the session to the treatment
                .nurseId(nurseId)
                .weightBefore(weightBefore)
                .sessionDate(LocalDateTime.now())
                .build();

        return sessionRepository.save(session);
    }

    @Override
    public DialysisSession endSession(UUID sessionId, Double weightAfter) {
        DialysisSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setWeightAfter(weightAfter);

        // Simple Math (Level 1)
        if (session.getWeightBefore() != null) {
            session.setUltrafiltrationVolume(session.getWeightBefore() - weightAfter);
        }

        return sessionRepository.save(session);
    }

    @Override
    public List<DialysisSession> getSessionsByTreatment(UUID treatmentId) {
        return sessionRepository.findByTreatmentId(treatmentId);
    }
    @Override
    public DialysisSession getSessionById(UUID id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    @Override
    public DialysisSession updateSession(UUID id, DialysisSession sessionDetails) {
        DialysisSession existingSession = getSessionById(id);

        // Update editable fields (e.g. Nurse made a typo)
        existingSession.setWeightBefore(sessionDetails.getWeightBefore());
        existingSession.setWeightAfter(sessionDetails.getWeightAfter());
        existingSession.setPreBloodPressure(sessionDetails.getPreBloodPressure());
        existingSession.setComplications(sessionDetails.getComplications());

        // If dates need correction
        if(sessionDetails.getSessionDate() != null) {
            existingSession.setSessionDate(sessionDetails.getSessionDate());
        }

        // Re-calculate Ultrafiltration if weights changed (Mini-Math logic)
        if(existingSession.getWeightBefore() != null && existingSession.getWeightAfter() != null) {
            existingSession.setUltrafiltrationVolume(
                    existingSession.getWeightBefore() - existingSession.getWeightAfter()
            );
        }

        return sessionRepository.save(existingSession);
    }

    @Override
    public void deleteSession(UUID id) {
        if (!sessionRepository.existsById(id)) {
            throw new RuntimeException("Session not found");
        }
        sessionRepository.deleteById(id);
    }
    @Override
    public List<DialysisSession> getAllSessions() {
        return sessionRepository.findAll();
    }
}