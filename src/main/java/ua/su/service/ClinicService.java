package ua.su.service;

import ua.su.domain.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> findAll();

    Clinic getEntry(Long id);

    void delete(Long id);

    Clinic addEntry(Clinic clinic);

    Clinic update(Long id, Clinic clinic);

    List<String> findByCriteriaSQL(Integer n);

    List<String> findByCriteriaStreamAPI(Integer n);

}
