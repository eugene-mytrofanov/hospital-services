package ua.su.service.impl;

import org.springframework.stereotype.Service;
import ua.su.domain.Clinic;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.FindSomethingByCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicServiceSearchStreamApi extends ClinicServiceImpl implements FindSomethingByCriteria {

    public ClinicServiceSearchStreamApi(ClinicRepository clinicRepository, MedicalProcedureRepository medicalProcedureRepository) {
        super(clinicRepository, medicalProcedureRepository);
    }

    @Override
    public List<String> findClinicAddressesWhereInsuranceNotSupportedAndDoctorsNumberLessThanNOrderedAsc(Integer n) {
        List<Clinic> clinics = clinicRepository.findAll();
        return clinics.stream()
                .filter(clinic -> !clinic.getIsInsuranceSupported() && clinic.getNumberOfDoctors() < n)
                .map(clinic -> clinic.getAddress())
                .sorted()
                .collect(Collectors.toList());
    }
}
