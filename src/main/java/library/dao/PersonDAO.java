package library.dao;

import library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("Select * from person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("select * from person where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

//    public Person show(String name){
//        return jdbcTemplate.query("SELECT FROM Person where name=?",new Object[]{name},
//                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//    }

    public void save(Person person){
        jdbcTemplate.update("insert into person(name,yearOfBirth) values(?,?)",
                person.getName(),person.getYearOfBirth());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("update person set name=?,yearofbirth=? where id=?",
                updatedPerson.getName(),updatedPerson.getYearOfBirth(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from person where id=?",id);
    }
}
