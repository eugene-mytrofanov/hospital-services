package ua.su.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.su.domain.MedicalProcedure;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.repository.base.AbstractRepository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MedicalProcedureRepositoryImpl extends AbstractRepository implements MedicalProcedureRepository {

    private static final BeanPropertyRowMapper<MedicalProcedure> ROW_MAPPER =
            new BeanPropertyRowMapper<>(MedicalProcedure.class);

    @Autowired
    public MedicalProcedureRepositoryImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<MedicalProcedure> findAll() {
        return jdbcTemplate.query("SELECT * FROM medical_procedures;", ROW_MAPPER);
    }

    @Override
    public MedicalProcedure getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM medical_procedures WHERE id = ?", ROW_MAPPER, id);
    }

    public List<MedicalProcedure> getAllByClinicId(Long clinicId) {
        return jdbcTemplate.query("SELECT * FROM medical_procedures WHERE clinic_id = ?", new BeanPropertyRowMapper<>(MedicalProcedure.class), clinicId);
    }

    @Override
    public MedicalProcedure insert(Long clinicId, MedicalProcedure medicalProcedure) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement("INSERT INTO medical_procedures(title, price, insurance_coverage, " +
                                    "procedure_duration, clinic_id) VALUES (?, ?, ?, ?, ?)",
                            new String[]{"id"});
            ps.setString(1, medicalProcedure.getTitle());
            ps.setDouble(2, medicalProcedure.getPrice());
            ps.setInt(3, medicalProcedure.getInsuranceCoverage());
            ps.setInt(4, medicalProcedure.getProcedureDuration());
            ps.setLong(5, clinicId);
            return ps;
        }, keyHolder);
        long medicalProcedureId = keyHolder.getKey().longValue();
        medicalProcedure.setId(medicalProcedureId);
        return getOne(medicalProcedureId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM medical_procedures WHERE id = ?", id);
    }

    @Override
    public void deleteByClinicId(Long clinicId) {
        jdbcTemplate.update("DELETE FROM medical_procedures WHERE clinic_id = ?", clinicId);
    }

    @Override
    public MedicalProcedure update(Long id, MedicalProcedure medicalProcedure) {
        jdbcTemplate.update("UPDATE medical_procedures SET title = ?, price = ?, insurance_coverage = ?, procedure_duration = ? WHERE id = ?",
                medicalProcedure.getTitle(),
                medicalProcedure.getPrice(),
                medicalProcedure.getInsuranceCoverage(),
                medicalProcedure.getProcedureDuration(), id);
        return getOne(id);
    }
}
