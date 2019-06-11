package ua.su.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.su.domain.Clinic;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.FindSomethingByCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindSomethingInClinic2 extends ClinicServiceImpl implements FindSomethingByCriteria {

    @Autowired
    public FindSomethingInClinic2(ClinicRepository clinicRepository, MedicalProcedureRepository medicalProcedureRepository) {
        super(clinicRepository, medicalProcedureRepository);
    }

    //  The method returns the ordered list of clinic addresses where insurance is not supported and number of doctors less than n

    @Override
    public List<String> findSomethingByCriteriaOrderedAsc(Integer n) {
        List<Clinic> clinics = clinicRepository.findAll();
        return clinics.stream()
                .filter(clinic -> !clinic.isInsuranceSupported() && clinic.getNumberOfDoctors() < n)
                .map(clinic -> clinic.getAddress())
                .sorted()
                .collect(Collectors.toList());
    }
}
