package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.FindSomethingByCriteria;

import java.util.List;

@Service
public class FindSomethingInClinic1 extends ClinicServiceImpl implements FindSomethingByCriteria {

    @Autowired
    public FindSomethingInClinic1(ClinicRepository clinicRepository, MedicalProcedureRepository medicalProcedureRepository) {
        super(clinicRepository, medicalProcedureRepository);
    }

    //  The method returns the ordered list of clinic addresses where insurance is not supported and number of doctors less than n

    @Override
    public List<String> findSomethingByCriteriaOrderedAsc(Integer n) {
        return clinicRepository.findByCriteria(n);
    }
}
