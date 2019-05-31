package ua.su.repository.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.MedicalProcedureRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MedicalProcedureRepositoryImpl implements MedicalProcedureRepository {

    private static final BeanPropertyRowMapper<MedicalProcedure> ROW_MAPPER =
            new BeanPropertyRowMapper<>(MedicalProcedure.class);

    private final JdbcTemplate jdbcTemplate;

    public MedicalProcedureRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MedicalProcedure> findAll() {
        return jdbcTemplate.query("SELECT * FROM medical_procedures;", ROW_MAPPER);
    }

    @Override
    public MedicalProcedure getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM medical_procedures WHERE id = ?", ROW_MAPPER, id);
    }

    @Override
    public MedicalProcedure insert(MedicalProcedure medicalProcedure, Integer clinicId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("insert into medical_procedures(title, price, insurance_coverage, " +
                                    "procedure_duration, clinic_id) values (?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, medicalProcedure.getTitle());
            ps.setDouble(2, medicalProcedure.getPrice());
            ps.setInt(3, medicalProcedure.getInsuranceCoverage());
            ps.setInt(4, medicalProcedure.getProcedureDuration());
            ps.setInt(5, clinicId);
            return ps;
        }, keyHolder);
        long medicalProcedureId = keyHolder.getKey().longValue();
        return getOne(medicalProcedureId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM medical_procedures where id = ?", id);
    }

    @Override
    public MedicalProcedure update(Long id, MedicalProcedure medicalProcedure) {
        jdbcTemplate.update("update medical_procedures set title = ?, price = ?, insurance_coverage = ?, procedure_duration = ?," +
                        ", where id = ?",
                medicalProcedure.getTitle(),
                medicalProcedure.getPrice(),
                medicalProcedure.getInsuranceCoverage(),
                medicalProcedure.getProcedureDuration(), id);
        return getOne(id);
    }
}
