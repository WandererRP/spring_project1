package ru.rol.springproject1.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rol.springproject1.models.Person;

import java.util.List;



@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Person> index(){
        //return jdbcTemplate.query("SELECT * FROM person", new PersonMapper() );
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class) );
    }

    public Person show(int person_id){

        //return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?",
                new BeanPropertyRowMapper<>(Person.class), person_id).stream().findAny().orElse(null);
    }



    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(fullname, year_of_birth) VALUES (?,?)",
                person.getFullname(), person.getYear_of_birth());
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE person SET fullname=?, year_of_birth=? where person_id=?",
                person.getFullname(), person.getYear_of_birth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person where person_id=?", id);

    }



}
