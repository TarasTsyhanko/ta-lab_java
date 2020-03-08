package banksystem.jdbc.service;

import banksystem.jdbc.bo.Util;
import banksystem.jdbc.dao.BookDAO;
import banksystem.jdbc.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService extends Util implements BookDAO {
    private Connection connection;

    public BookService() {
         connection = getConnection();
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("IDBook"));
                book.setBookName(resultSet.getString("BookName"));
                book.setAuthor(resultSet.getString("Author"));
                book.setAmount(resultSet.getInt("Amount"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return books;
    }

    @Override
    public void insertBook(Book book) {
        String sql = "INSERT INTO Book (IDBook, BookName, Author, Amount) VALUE(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setInt(4, book.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE Book SET BookName=?, Author=?, Amount=? WHERE IDBook=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,book.getBookName());
            statement.setString(2,book.getAuthor());
            statement.setInt(3,book.getAmount());
            statement.setInt(4 ,book.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "DELETE FROM Book WHERE IDBook=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,book.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
