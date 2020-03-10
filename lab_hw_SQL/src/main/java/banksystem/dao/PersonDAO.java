package banksystem.dao;

import client.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPerson();

    Person getPersonByName(String firstName, String lastName);

    void insertPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Person person);

    public boolean isPersonExists(String firstName, String lastName);
}
