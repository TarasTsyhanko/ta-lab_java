package com.epam.sql.banksystem.jdbc.dao;

import com.epam.sql.banksystem.jdbc.entity.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPerson();
    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
