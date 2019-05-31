package ua.su.repository;

import ua.su.domain.Clinic;

import java.util.List;

public interface ClinicRepository {

    List<Clinic> findAll();
    Clinic getOne(Long id);
    Clinic insert(Clinic clinic);
    void delete(Long id);
    Clinic update(Long id, Clinic clinic);
}
