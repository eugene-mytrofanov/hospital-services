package ua.su.service;

import ua.su.domain.Clinic;

import java.util.List;
import java.util.Map;

public interface ClinicService {
    List<Clinic> findAll();

    Clinic getEntry(Long id);

    void delete(Long id);

    Clinic addEntry(Clinic clinic);

    Clinic update(Long id, Clinic clinic);

    Clinic partialUpdate(Long id, Map<String, Object> fields);
}
