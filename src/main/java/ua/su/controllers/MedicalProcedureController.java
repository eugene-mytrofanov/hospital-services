package ua.su.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.su.domain.MedicalProcedure;
import ua.su.service.MedicalProcedureService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalProcedureController {

    private final MedicalProcedureService medicalProcedureService;

    @Autowired
    public MedicalProcedureController(MedicalProcedureService medicalProcedureService) {
        this.medicalProcedureService = medicalProcedureService;
    }

    @GetMapping(value = "/medical_procedures")
    public List<MedicalProcedure> getMedicalProcedures() {
        return medicalProcedureService.findAll();
    }

    @GetMapping(value = "/medical_procedures/{id}")
    public MedicalProcedure getMedicalProcedure(@PathVariable Long id) {
        return medicalProcedureService.getEntry(id);
    }

    @PostMapping(value = "/clinics/{clinicId}/medical_procedures")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalProcedure createMedicalProcedure(@PathVariable Long clinicId, @RequestBody MedicalProcedure medicalProcedure) {
        return medicalProcedureService.addEntry(clinicId, medicalProcedure);
    }

    @DeleteMapping(value = "/medical_procedures/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicalProcedure(@PathVariable Long id) {
        medicalProcedureService.delete(id);
    }

    @PutMapping(value = "/medical_procedures/{id}")
    public MedicalProcedure updateMedicalProcedure(@PathVariable Long id, @RequestBody MedicalProcedure medicalProcedure) {
        return medicalProcedureService.update(id, medicalProcedure);
    }

    @PatchMapping(value = "/medical_procedures/{id}")
    public MedicalProcedure patchMedicalProcedure(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
        return medicalProcedureService.partialUpdate(id, fields);
    }
}