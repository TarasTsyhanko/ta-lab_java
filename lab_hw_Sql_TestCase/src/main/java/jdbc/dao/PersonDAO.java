package jdbc.dao;

import jdbc.entity.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPerson();
    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
