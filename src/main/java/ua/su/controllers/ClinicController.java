package ua.su.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.su.domain.Clinic;
import ua.su.service.ClinicService;

import java.util.List;

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

}
