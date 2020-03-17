package jdbc.dao;

import jdbc.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBook();
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);

}
