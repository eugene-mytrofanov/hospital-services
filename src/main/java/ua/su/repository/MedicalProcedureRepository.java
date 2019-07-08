package ua.su.repository;

import ua.su.domain.MedicalProcedure;
import ua.su.repository.base.BasicRepository;
import ua.su.repository.base.ChildRepository;

import java.util.List;

public interface MedicalProcedureRepository extends BasicRepository <Long, MedicalProcedure>, ChildRepository <Long, MedicalProcedure> {

    List<MedicalProcedure> findAll();

    MedicalProcedure getOne(Long id);

    List<MedicalProcedure> getAllByClinicId(Long clinicId);

    MedicalProcedure insert(Long clinicId, MedicalProcedure medicalProcedure);

    void delete(Long id);

    void deleteByClinicId(Long clinicId);

    MedicalProcedure update(Long id, MedicalProcedure medicalProcedure);
}
