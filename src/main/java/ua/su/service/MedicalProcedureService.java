package ua.su.service;

import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureService {

    List<MedicalProcedure> findAll();

    MedicalProcedure getEntry(Long id);

    void delete(Long id);

    MedicalProcedure addEntry(MedicalProcedure medicalProcedure, Integer clinicId);

    MedicalProcedure update(Long id, MedicalProcedure medicalProcedure);
}
