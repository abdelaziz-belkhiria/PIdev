package org.example.hospitalization1.service;

import org.example.hospitalization1.entities.hospitalization;
import org.example.hospitalization1.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository repository;

    public List<hospitalization> findAll() {
        return repository.findAll();
    }

    public hospitalization findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public hospitalization save(hospitalization hospitalization) {
        return repository.save(hospitalization);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}