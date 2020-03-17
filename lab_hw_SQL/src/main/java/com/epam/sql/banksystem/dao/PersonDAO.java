package com.epam.sql.banksystem.dao;

import java.util.List;

public interface PersonDAO<T> {
    List<T> getAllPerson();

    T getPersonByName(String firstName, String lastName);

    void insertPerson(T t);

    void updatePerson(T t);

    void deletePerson(T t);

     boolean isPersonExists(String firstName, String lastName);
}
