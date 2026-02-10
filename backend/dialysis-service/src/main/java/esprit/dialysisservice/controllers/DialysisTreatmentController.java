package esprit.dialysisservice.controllers;


import esprit.dialysisservice.entities.DialysisTreatment;
import esprit.dialysisservice.services.IDialysisTreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/treatments")
@RequiredArgsConstructor
public class DialysisTreatmentController {

    private final IDialysisTreatmentService treatmentService;

    // 1. Create (Already there)
    @PostMapping
    public DialysisTreatment createTreatment(@RequestBody DialysisTreatment treatment) {
        return treatmentService.addTreatment(treatment);
    }

    // 2. Get All Treatments (MISSING - Added now)
    @GetMapping
    public List<DialysisTreatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    // 3. Get Single Treatment
    @GetMapping("/{id}")
    public DialysisTreatment getById(@PathVariable UUID id) {
        return treatmentService.getTreatmentById(id);
    }

    // 4. Get by Patient
    @GetMapping("/patient/{patientId}")
    public List<DialysisTreatment> getByPatient(@PathVariable UUID patientId) {
        return treatmentService.getTreatmentsByPatient(patientId);
    }

    // 5. Update Treatment (MISSING - Added now)
    @PutMapping("/{id}")
    public DialysisTreatment updateTreatment(@PathVariable UUID id, @RequestBody DialysisTreatment treatmentDetails) {
        // Ensure the ID in the body matches the URL or set it here
        treatmentDetails.setId(id);
        return treatmentService.updateTreatment(treatmentDetails);
    }

    // 6. Delete Treatment (MISSING - Added now)
    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable UUID id) {
        treatmentService.deleteTreatment(id);
    }
}