package org.example.hospitalization1.service;

import org.example.hospitalization1.entities.VitalSigns;
import org.example.hospitalization1.repository.VitalSignsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignsService {

    @Autowired
    private VitalSignsRepository repository;

    public List<VitalSigns> findAll() {
        return repository.findAll();
    }

    public VitalSigns findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public VitalSigns save(VitalSigns vitalSigns) {
        return repository.save(vitalSigns);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}