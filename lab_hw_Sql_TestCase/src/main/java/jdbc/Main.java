package jdbc;

import jdbc.entity.Book;
import jdbc.dao.BookDAO;
import jdbc.service.BookService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookService();
        List<Book> books = bookDAO.getAllBook();
        for (Book book : books) {
            System.out.println(book.getId() + " " + book.getBookName() + " " + book.getAuthor() + " " + book.getAmount());
        }
        Book book1 = books.get(0);
        bookDAO.deleteBook(book1);
        books = bookDAO.getAllBook();
        System.out.println("------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book.getId() + " " + book.getBookName() + " " + book.getAuthor() + " " + book.getAmount());
        }
        bookDAO.insertBook(book1);

    }
}
