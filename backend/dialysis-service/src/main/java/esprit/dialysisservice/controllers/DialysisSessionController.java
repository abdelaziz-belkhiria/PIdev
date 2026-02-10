package esprit.dialysisservice.controllers;


import esprit.dialysisservice.entities.DialysisSession;
import esprit.dialysisservice.services.IDialysisSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class DialysisSessionController {

    private final IDialysisSessionService sessionService;

    // 1. Start Session
    @PostMapping("/start")
    public DialysisSession startSession(@RequestParam UUID treatmentId,
                                        @RequestParam Double weight,
                                        @RequestParam UUID nurseId) {
        return sessionService.startSession(treatmentId, weight, nurseId);
    }

    // 2. End Session
    @PutMapping("/{id}/end")
    public DialysisSession endSession(@PathVariable UUID id,
                                      @RequestParam Double weightAfter) {
        return sessionService.endSession(id, weightAfter);
    }

    // 3. Get All Sessions (MISSING - Added now)
    @GetMapping
    public List<DialysisSession> getAllSessions() {
        return sessionService.getAllSessions();
    }

    // 4. Get Single Session
    @GetMapping("/{id}")
    public DialysisSession getSessionById(@PathVariable UUID id) {
        return sessionService.getSessionById(id);
    }

    // 5. Get History by Treatment
    @GetMapping("/treatment/{treatmentId}")
    public List<DialysisSession> getHistory(@PathVariable UUID treatmentId) {
        return sessionService.getSessionsByTreatment(treatmentId);
    }

    // 6. Update Session
    @PutMapping("/{id}")
    public DialysisSession updateSession(@PathVariable UUID id, @RequestBody DialysisSession sessionDetails) {
        return sessionService.updateSession(id, sessionDetails);
    }

    // 7. Delete Session
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable UUID id) {
        sessionService.deleteSession(id);
    }
}