package ua.su.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.su.repository.MedicalProcedureRepository;
import ua.su.repository.impl.MedicalProcedureRepositoryImpl;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MedicalProcedureRepository medicalProcedureRepository (JdbcTemplate jdbcTemplate){
        return new MedicalProcedureRepositoryImpl(jdbcTemplate);
    }

}
