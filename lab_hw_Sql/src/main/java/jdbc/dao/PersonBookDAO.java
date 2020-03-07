package jdbc.dao;

import jdbc.entity.Book;
import jdbc.entity.Person;

public interface PersonBookDAO {
    void insertPersonBook(Person person, Book book);
    void deletePersonBook(Person person);
}
