package esprit.dialysisservice.services;

import esprit.dialysisservice.entities.DialysisSession;
import esprit.dialysisservice.entities.DialysisTreatment;

import java.util.List;
import java.util.UUID;

public interface IDialysisSessionService {
    DialysisSession startSession(UUID treatmentId, Double weightBefore, UUID nurseId);

    DialysisSession endSession(UUID sessionId, Double weightAfter);

    List<DialysisSession> getSessionsByTreatment(UUID treatmentId);
    DialysisSession getSessionById(UUID id);
    DialysisSession updateSession(UUID id, DialysisSession sessionDetails); // For fixing typos
    void deleteSession(UUID id); // For cleanup
    List<DialysisSession> getAllSessions();
}