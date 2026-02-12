package org.example.hospitalizationservice.repository;

import org.example.hospitalizationservice.entities.hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalizationRepository extends JpaRepository<hospitalization, String> {
}