package org.example.hospitalization1.controller;

import org.example.hospitalization1.entities.hospitalization;
import org.example.hospitalization1.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalizations")
public class HospitalizationController {

    @Autowired
    private HospitalizationService service;

    @GetMapping
    public List<hospitalization> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public hospitalization getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public hospitalization create(@RequestBody hospitalization hospitalization) {
        return service.save(hospitalization);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}