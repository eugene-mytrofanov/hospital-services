package ua.su.repository;

import ua.su.domain.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureRepository {

    List <MedicalProcedure> findAll();
    MedicalProcedure getOne(Long id);
    MedicalProcedure insert(MedicalProcedure medicalProcedure, Integer clinicId);
    void delete(Long id);
    MedicalProcedure update(Long id, MedicalProcedure medicalProcedure);
}
