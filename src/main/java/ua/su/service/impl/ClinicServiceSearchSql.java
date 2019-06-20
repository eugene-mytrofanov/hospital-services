package ua.su.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ua.su.repository.ClinicRepository;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.service.FindSomethingByCriteria;

import java.util.List;

@Service
@Primary
public class ClinicServiceSearchSql extends ClinicServiceImpl implements FindSomethingByCriteria {


    public ClinicServiceSearchSql(ClinicRepository clinicRepository, MedicalProcedureRepository medicalProcedureRepository) {
        super(clinicRepository, medicalProcedureRepository);
    }

    @Override
    public List<String> findClinicAddressesWhereInsuranceNotSupportedAndDoctorsNumberLessThanNOrderedAsc(Integer n) {
        return clinicRepository.findByCriteria(n);
    }
}
