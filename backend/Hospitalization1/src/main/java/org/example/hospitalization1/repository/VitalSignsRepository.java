package org.example.hospitalization1.repository;

import org.example.hospitalization1.entities.VitalSigns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalSignsRepository extends JpaRepository<VitalSigns, String> {
}