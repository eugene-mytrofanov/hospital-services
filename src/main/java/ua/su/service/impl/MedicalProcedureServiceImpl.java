package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.MedicalProcedureService;

import java.util.List;

@Service
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    private final MedicalProcedureRepository medicalProcedureRepository;

    @Autowired
    public MedicalProcedureServiceImpl(MedicalProcedureRepository medicalProcedureRepository) {
        this.medicalProcedureRepository = medicalProcedureRepository;
    }

    @Override
    public List<MedicalProcedure> findAll() {
        return medicalProcedureRepository.findAll();
    }

    @Override
    public MedicalProcedure getEntry(Long id) {
        return medicalProcedureRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        medicalProcedureRepository.delete(id);
    }

    @Override
    public void deleteByClinicId(Long clinicId){
        medicalProcedureRepository.deleteByClinicId(clinicId);
    }

    @Override
    public MedicalProcedure addEntry(MedicalProcedure medicalProcedure, Long clinicId) {
        return medicalProcedureRepository.insert(medicalProcedure, clinicId);
    }

    @Override
    public MedicalProcedure update(Long id, MedicalProcedure medicalProcedure) {
        return medicalProcedureRepository.update(id, medicalProcedure);
    }
}
