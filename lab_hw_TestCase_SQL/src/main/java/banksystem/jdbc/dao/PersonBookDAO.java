package banksystem.jdbc.dao;

import banksystem.jdbc.entity.Book;
import banksystem.jdbc.entity.Person;

public interface PersonBookDAO {
    void insertPersonBook(Person person, Book book);
    void deletePersonBook(Person person);
}
