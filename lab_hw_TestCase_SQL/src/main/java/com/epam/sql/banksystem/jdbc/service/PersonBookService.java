package com.epam.sql.banksystem.jdbc.service;

import com.epam.sql.banksystem.jdbc.bo.Util;
import com.epam.sql.banksystem.jdbc.dao.PersonBookDAO;
import com.epam.sql.banksystem.jdbc.entity.Book;
import com.epam.sql.banksystem.jdbc.entity.Person;

import java.sql.*;

public class PersonBookService extends Util implements PersonBookDAO {
    private Connection connection;

    public PersonBookService() {
        connection = getConnection();
    }

    @Override
    public void insertPersonBook(Person person ,Book book) {
        String sql = "INSERT INTO PersonBook (IDPerson, IDBook) VALUE(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setInt(1, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void deletePersonBook(Person person) {
        String sql = "DELETE FROM PersonBook WHERE IDPerson=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,person.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
