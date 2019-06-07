package ua.su.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
        return jdbcTemplate.queryForObject("SELECT * FROM clinics WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public Clinic insert(Clinic clinic) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into clinics(name, address, phone, is_insurance_supported, " +
                                    "clinic_type, number_of_doctors) values (?, ?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, clinic.getName());
            ps.setString(2, clinic.getAddress());
            ps.setString(3, clinic.getPhone());
            ps.setBoolean(4, clinic.isInsuranceSupported());
            ps.setObject(5, clinic.getClinicType());
            ps.setInt(6, clinic.getNumberOfDoctors());
            return ps;
        }, keyHolder);
        long clinicId = keyHolder.getKey().longValue();
        clinic.setId(clinicId);
        return getOne(clinicId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM clinics where id = ?", id);
    }

    @Override
    public Clinic update(Long id, Clinic clinic) {
        jdbcTemplate.update("update clinics set name = ?, address = ?, phone = ?, is_insurance_supported = ?," +
                        "clinic_type = ?, number_of_doctors = ?, where id = ?",
                clinic.getName(), clinic.getAddress(), clinic.getPhone(), clinic.isInsuranceSupported(),
                clinic.getClinicType(), clinic.getNumberOfDoctors(), id);
        return getOne(id);
    }

    public List<MedicalProcedure> getAllByClinicId(Long id) {
        return jdbcTemplate.queryForList("SELECT * FROM medical_procedures WHERE clinic_id = ?", MedicalProcedure.class, id);
    }

//    Список адресов клиник у которых нет возможности пользоваться страховкой и у который врачей меньше n,
//    отсортированных в алфавитном порядке

    @Override
    public List<String> findByCriteria(Integer n) {
        return jdbcTemplate.queryForList("SELECT address FROM clinics WHERE is_insurance_supported = false AND " +
                "number_of_doctors > ? ORDER BY address ASC;", String.class, n);
    }
}