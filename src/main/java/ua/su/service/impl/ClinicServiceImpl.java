package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import ua.su.config.ApplicationConfiguration;
import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.repository.impl.MedicalProcedureRepositoryImpl;
import ua.su.service.ClinicService;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getEntry(Long id) {
        Clinic c = clinicRepository.getOne(id);
        List <MedicalProcedure> medicalProcedures = clinicRepository.getAllByClinicId(id);
        c.setMedicalProcedures(medicalProcedures);
        return c;
    }

    @Override
    public void delete(Long id) {
        clinicRepository.delete(id);
    }

    @Override
    public Clinic addEntry(Clinic clinic) {
        Clinic c = clinicRepository.insert(clinic);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        MedicalProcedureRepositoryImpl medicalProcedureRepository = ctx.getBean(MedicalProcedureRepositoryImpl.class);

        List<MedicalProcedure> mp = clinic.getMedicalProcedures();
//        for (MedicalProcedure medicalProcedure :) {
//            medicalProcedureRepository.insert();
//        }

        // TO DO: insert child instances 'Medical Procedure'

        return c;
    }

    @Override
    public Clinic update(Long id, Clinic clinic) {
        return null;
    }

    @Override
    public List<Clinic> findByCriteria() {
        return null;
    }
}
