package ua.su.repository;

import ua.su.domain.Clinic;
import ua.su.repository.base.BasicRepository;
import ua.su.repository.base.ParentRepository;

import java.util.List;

public interface ClinicRepository extends BasicRepository <Long, Clinic>, ParentRepository <Clinic> {

    List<Clinic> findAll();

    List<String> findByCriteria(Integer n);

    Clinic getOne(Long id);

    Clinic insert(Clinic clinic);

    void delete(Long id);

    Clinic update(Long id, Clinic clinic);
}
