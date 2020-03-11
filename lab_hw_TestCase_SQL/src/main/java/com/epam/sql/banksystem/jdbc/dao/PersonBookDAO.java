package com.epam.sql.banksystem.jdbc.dao;

import com.epam.sql.banksystem.jdbc.entity.Book;
import com.epam.sql.banksystem.jdbc.entity.Person;

public interface PersonBookDAO {
    void insertPersonBook(Person person, Book book);
    void deletePersonBook(Person person);
}
