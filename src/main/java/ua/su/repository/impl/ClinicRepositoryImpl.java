package ua.su.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.su.domain.Clinic;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.ClinicRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ClinicRepositoryImpl implements ClinicRepository {

    private static final BeanPropertyRowMapper<Clinic> ROW_MAPPER =
            new BeanPropertyRowMapper<>(Clinic.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClinicRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Clinic> findAll() {
        return jdbcTemplate.query("SELECT * FROM clinics;", ROW_MAPPER);
    }

    @Override
    public Clinic getOne(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM clinics WHERE id = ?", ROW_MAPPER, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Clinic insert(Clinic clinic) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("INSERT INTO clinics(name, address, phone, is_insurance_supported, " +
                                    "clinic_type, number_of_doctors) VALUES (?, ?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, clinic.getName());
            ps.setString(2, clinic.getAddress());
            ps.setString(3, clinic.getPhone());
            ps.setBoolean(4, clinic.getIsInsuranceSupported());
            ps.setString(5, clinic.getClinicType().toString());
            ps.setInt(6, clinic.getNumberOfDoctors());
            return ps;
        }, keyHolder);
        long clinicId = keyHolder.getKey().longValue();
        clinic.setId(clinicId);
        return getOne(clinicId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM clinics WHERE id = ?", id);
    }

    @Override
    public Clinic update(Long id, Clinic clinic) {
        jdbcTemplate.update("UPDATE clinics SET name = ?, address = ?, phone = ?, is_insurance_supported = ?," +
                        "clinic_type = ?, number_of_doctors = ? WHERE id = ?",
                clinic.getName(),
                clinic.getAddress(),
                clinic.getPhone(),
                clinic.getIsInsuranceSupported(),
                clinic.getClinicType().toString(),
                clinic.getNumberOfDoctors(), id);
        return getOne(id);
    }

    public List<MedicalProcedure> getAllByClinicId(Long id) {
        return jdbcTemplate.query("SELECT * FROM medical_procedures WHERE clinic_id = ?", new BeanPropertyRowMapper<>(MedicalProcedure.class), id);
    }

    public List<String> findByCriteria(Integer n) {
        return jdbcTemplate.queryForList("SELECT address FROM clinics WHERE is_insurance_supported = false AND " +
                "number_of_doctors > ? ORDER BY address ASC;", String.class, n);
    }
}