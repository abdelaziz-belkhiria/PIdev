package esprit.dialysisservice.services;

import esprit.dialysisservice.entities.DialysisTreatment;

import java.util.List;
import java.util.UUID;

public interface IDialysisTreatmentService {
    DialysisTreatment addTreatment(DialysisTreatment treatment);
    DialysisTreatment updateTreatment(DialysisTreatment treatment);
    List<DialysisTreatment> getAllTreatments();
    List<DialysisTreatment> getTreatmentsByPatient(UUID patientId);
    DialysisTreatment getTreatmentById(UUID id);
    void deleteTreatment(UUID id);
}