package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;
import ua.su.exceptions.data.ResourceNotFoundException;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.MedicalProcedureService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    private final MedicalProcedureRepository medicalProcedureRepository;
    private final ClinicRepository clinicRepository;

    @Autowired
    public MedicalProcedureServiceImpl(MedicalProcedureRepository medicalProcedureRepository, ClinicRepository clinicRepository) {
        this.medicalProcedureRepository = medicalProcedureRepository;
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<MedicalProcedure> findAll() {
        return medicalProcedureRepository.findAll();
    }

    @Override
    public MedicalProcedure getEntry(Long id) {
        MedicalProcedure medicalProcedure = medicalProcedureRepository.getOne(id);
        if (medicalProcedure == null) {
            throw new ResourceNotFoundException("Cannot find medical procedure with id " + id);
        }
        return medicalProcedure;
    }

    @Override
    public void delete(Long id) {
        MedicalProcedure medicalProcedure = medicalProcedureRepository.getOne(id);
        if (medicalProcedure == null) {
            throw new ResourceNotFoundException("Cannot find medical procedure with id " + id);
        }
        medicalProcedureRepository.delete(id);
    }

    @Override
    public void deleteByClinicId(Long clinicId) {
        Clinic clinicFromRepository = clinicRepository.getOne(clinicId);
        if (clinicFromRepository == null) {
            throw new ResourceNotFoundException("Cannot find clinic with id " + clinicId);
        }
        medicalProcedureRepository.deleteByClinicId(clinicId);
    }

    @Override
    public MedicalProcedure addEntry(MedicalProcedure medicalProcedure, Long clinicId) {
        return medicalProcedureRepository.insert(medicalProcedure, clinicId);
    }

    @Override
    public MedicalProcedure update(Long id, MedicalProcedure medicalProcedure) {
        MedicalProcedure medicalProcedureFromRepository = medicalProcedureRepository.getOne(id);
        if (medicalProcedureFromRepository == null) {
            throw new ResourceNotFoundException("Cannot find medical procedure with id " + id);
        }
        return medicalProcedureRepository.update(id, medicalProcedure);
    }

    @Override
    public MedicalProcedure partialUpdate(Long id, Map<String, Object> fields) {
        MedicalProcedure medicalProcedureFromRepo = medicalProcedureRepository.getOne(id);
        if (medicalProcedureFromRepo == null) {
            throw new ResourceNotFoundException("Cannot find medical procedure with id " + id);
        }

        if (fields == null || fields.isEmpty()) {
            throw new ResourceNotFoundException("The fields are invalid");
        }

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Clinic.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, medicalProcedureFromRepo, v);
        });
        medicalProcedureRepository.update(id, medicalProcedureFromRepo);
        return medicalProcedureFromRepo;
    }
}
