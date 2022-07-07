package com.company.DAO;

import com.company.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPeople(){
        return jdbcTemplate.query("SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getOnePerson(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void createPerson(Person person){
        String full_name = person.getFull_name();
        String birthday = person.getBirthday();

        jdbcTemplate.update("INSERT INTO Person(full_name, birthday) VALUES (?, ?)",
                person.getFull_name(), person.getBirthday());
    }

    public void editPerson(int id, Person editedPerson){
        String full_name = editedPerson.getFull_name();
        String birthday = editedPerson.getBirthday();

        jdbcTemplate.update("UPDATE Person SET full_name = ? , birthday = ? " +
                "WHERE person_id = ?", full_name, birthday, id);
    }

    public void deletePerson(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE person_id = ?", id);
    }
}
