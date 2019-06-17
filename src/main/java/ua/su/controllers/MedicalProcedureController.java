package ua.su.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.su.domain.MedicalProcedure;
import ua.su.service.MedicalProcedureService;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicalProcedureController {

    private final MedicalProcedureService medicalProcedureService;

    public MedicalProcedureController(MedicalProcedureService medicalProcedureService) {
        this.medicalProcedureService = medicalProcedureService;
    }

    @GetMapping(value = "/medical-procedures")
    public List<MedicalProcedure> getMedicalProcedures() {
        return medicalProcedureService.findAll();
    }

    @GetMapping(value = "/medical-procedures/{id}")
    public MedicalProcedure getMedicalProcedure(@PathVariable Long id) {
        return medicalProcedureService.getEntry(id);
    }

    @PostMapping(value = "/clinics/{clinicId}/medical-procedures")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalProcedure createMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure, @PathVariable Long clinicId) {
        return medicalProcedureService.addEntry(medicalProcedure, clinicId);
    }

    @DeleteMapping(value = "/medical-procedures/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedicalProcedure(@PathVariable Long id) {
        medicalProcedureService.delete(id);
    }

    @PutMapping(value = "/medical-procedures/{id}")
    public MedicalProcedure updateMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure, @PathVariable Long id){
        return medicalProcedureService.update(id, medicalProcedure);
    }
}