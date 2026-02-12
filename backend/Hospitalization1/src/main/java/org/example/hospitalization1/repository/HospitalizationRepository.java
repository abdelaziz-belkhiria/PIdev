package org.example.hospitalization1.repository;

import org.example.hospitalization1.entities.hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalizationRepository extends JpaRepository<hospitalization, String> {
}