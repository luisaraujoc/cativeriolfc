package com.luisaraujoc.cativeriolfc.DAO;

import com.luisaraujoc.cativeriolfc.Entity.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        String sql = "INSERT INTO persons (full_name, birth_date, surname) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, person.getFullName(), person.getBirthDate(), person.getSurname());
    }

    public Person findById(Integer id) {
        String sql = "SELECT * FROM persons WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getDate("birth_date"),
                rs.getString("surname")
            );
        }
    }
}
