package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;
import ua.su.exceptions.data.ResourceNotFoundException;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.ClinicService;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;

@Transactional
public class ClinicServiceImpl implements ClinicService {

    protected final ClinicRepository clinicRepository;
    protected final MedicalProcedureRepository medicalProcedureRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository, MedicalProcedureRepository medicalProcedureRepository) {
        this.clinicRepository = clinicRepository;
        this.medicalProcedureRepository = medicalProcedureRepository;
    }

    @Override
    public List<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getEntry(Long id) {
        Clinic clinic = clinicRepository.getOne(id);
        if (clinic == null) {
            throw new ResourceNotFoundException("Cannot find clinic with id " + id);
        }
        List<MedicalProcedure> medicalProcedures = medicalProcedureRepository.getAllByClinicId(id);
        clinic.setMedicalProcedures(medicalProcedures);
        return clinic;
    }

    @Override
    public void delete(Long id) {
        Clinic clinic = clinicRepository.getOne(id);
        if (clinic == null) {
            throw new ResourceNotFoundException("Cannot find clinic with id " + id);
        }
        medicalProcedureRepository.deleteByClinicId(id);
        clinicRepository.delete(id);
    }

    @Override
    public Clinic addEntry(Clinic clinic) {
        Clinic newClinic = clinicRepository.insert(clinic);
        List<MedicalProcedure> medicalProcedures = clinic.getMedicalProcedures();
        Long clinicId = newClinic.getId();
        if (medicalProcedures != null) {
            for (MedicalProcedure medicalProcedure : medicalProcedures) {
                medicalProcedureRepository.insert(clinicId, medicalProcedure);
            }
        }
        return newClinic;
    }

    @Override
    public Clinic update(Long id, Clinic clinic) {
        Clinic clinicFromRepository = clinicRepository.getOne(id);
        if (clinicFromRepository == null) {
            throw new ResourceNotFoundException("Cannot find clinic with id " + id);
        }
        medicalProcedureRepository.deleteByClinicId(id);
        clinicRepository.update(id, clinic);
        List<MedicalProcedure> mpList = clinic.getMedicalProcedures();
        if (mpList != null) {
            for (MedicalProcedure medicalProcedure : mpList) {
                medicalProcedureRepository.insert(id, medicalProcedure);
            }
        }
        return getEntry(id);
    }

    @Override
    public Clinic partialUpdate(Long id, Map<String, Object> fields) {
        Clinic clinicFromRepository = clinicRepository.getOne(id);
        if (clinicFromRepository == null) {
            throw new ResourceNotFoundException("Cannot find clinic with id " + id);
        }

        if (fields == null || fields.isEmpty()) {
            throw new ResourceNotFoundException("The fields are invalid");
        }

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Clinic.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, clinicFromRepository, v);
        });
        clinicRepository.update(id, clinicFromRepository);
        return clinicFromRepository;
    }
}
