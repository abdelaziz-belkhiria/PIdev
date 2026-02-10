package esprit.dialysisservice.services;

import esprit.dialysisservice.entities.DialysisTreatment;
import esprit.dialysisservice.entities.enums.TreatmentStatus;
import esprit.dialysisservice.repositories.DialysisTreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DialysisTreatmentServiceImpl implements IDialysisTreatmentService {

    private final DialysisTreatmentRepository treatmentRepository;

    @Override
    public DialysisTreatment addTreatment(DialysisTreatment treatment) {
        // Business Logic: Set default status and date
        treatment.setStatus(TreatmentStatus.ACTIVE);
        if(treatment.getStartDate() == null) {
            treatment.setStartDate(LocalDate.now());
        }
        return treatmentRepository.save(treatment);
    }

    @Override
    public DialysisTreatment updateTreatment(DialysisTreatment treatment) {
        return treatmentRepository.save(treatment);
    }

    @Override
    public List<DialysisTreatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    @Override
    public List<DialysisTreatment> getTreatmentsByPatient(UUID patientId) {
        return treatmentRepository.findByPatientId(patientId);
    }

    @Override
    public DialysisTreatment getTreatmentById(UUID id) {
        return treatmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment not found"));
    }

    @Override
    public void deleteTreatment(UUID id) {
        treatmentRepository.deleteById(id);
    }
}