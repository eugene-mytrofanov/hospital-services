package ua.su.repository.base;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractRepository {
    protected final JdbcTemplate jdbcTemplate;

    public AbstractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
