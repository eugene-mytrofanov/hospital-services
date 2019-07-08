package ua.su.service;

import ua.su.domain.MedicalProcedure;

import java.util.List;
import java.util.Map;

public interface MedicalProcedureService {

    List<MedicalProcedure> findAll();

    MedicalProcedure getEntry(Long id);

    void delete(Long id);

    void deleteByClinicId(Long clinicId);

    MedicalProcedure addEntry(Long clinicId, MedicalProcedure medicalProcedure);

    MedicalProcedure update(Long id, MedicalProcedure medicalProcedure);

    MedicalProcedure partialUpdate(Long id, Map<String, Object> fields);
}
