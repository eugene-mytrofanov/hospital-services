package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.ClinicService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;
    private final MedicalProcedureRepository medicalProcedureRepository;

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
            throw new RuntimeException("Cannot find cat with id " + id);
        }
        List<MedicalProcedure> medicalProcedures = clinicRepository.getAllByClinicId(id);
        clinic.setMedicalProcedures(medicalProcedures);
        return clinic;
    }

    @Override
    public void delete(Long id) {
        clinicRepository.getOne(id);
        medicalProcedureRepository.deleteByClinicId(id);
        clinicRepository.delete(id);
    }

    @Override
    public Clinic addEntry(Clinic clinic) {
        Clinic newClinic = clinicRepository.insert(clinic);
        List<MedicalProcedure> mpList = clinic.getMedicalProcedures();
        Long clinicId = newClinic.getId();
        if (mpList != null) {
            for (MedicalProcedure medicalProcedure : mpList) {
                medicalProcedureRepository.insert(medicalProcedure, clinicId);
            }
        }
        return newClinic;
    }

    @Override
    public Clinic update(Long id, Clinic clinic) {
        clinicRepository.getOne(id);
        medicalProcedureRepository.deleteByClinicId(id);
        clinicRepository.update(id, clinic);
        List<MedicalProcedure> mpList = clinic.getMedicalProcedures();
        if (mpList != null) {
            for (MedicalProcedure medicalProcedure : mpList) {
                medicalProcedureRepository.insert(medicalProcedure, id);
            }
        }
        return getEntry(id);
    }

    @Override
    public List<String> findByCriteriaSQL(Integer n) {
        return clinicRepository.findByCriteria(n);
    }

//    Список адресов клиник у которых нет возможности пользоваться страховкой и у который врачей меньше n,
//    отсортированных в алфавитном порядке

    @Override
    public List<String> findByCriteriaStreamAPI(Integer n) {
        List<Clinic> clinics = clinicRepository.findAll();
        return clinics.stream()
                .filter(clinic -> !clinic.isInsuranceSupported() && clinic.getNumberOfDoctors() < n)
                .map(clinic -> clinic.getAddress())
                .sorted()
                .collect(Collectors.toList());
    }
}
