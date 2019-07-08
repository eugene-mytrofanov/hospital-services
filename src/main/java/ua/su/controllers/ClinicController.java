package ua.su.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.su.domain.Clinic;
import ua.su.service.ClinicService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/clinics", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public List<Clinic> getClinics() {
        return clinicService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Clinic getClinic(@PathVariable Long id){
        return clinicService.getEntry(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clinic createClinic (@RequestBody Clinic clinic){
        return clinicService.addEntry(clinic);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClinic(@PathVariable Long id){
        clinicService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public Clinic updateClinic(@RequestBody Clinic clinic, @PathVariable Long id){
        return clinicService.update(id, clinic);
    }

    @PatchMapping(value = "/{id}")
    public Clinic patchClinic(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return clinicService.partialUpdate(id, fields);
    }
}
