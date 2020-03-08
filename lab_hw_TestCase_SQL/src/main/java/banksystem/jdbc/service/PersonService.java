package banksystem.jdbc.service;

import banksystem.jdbc.bo.Util;
import banksystem.jdbc.dao.PersonDAO;
import banksystem.jdbc.entity.City;
import banksystem.jdbc.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService extends Util implements PersonDAO {
    private Connection connection;

    public PersonService() {
        connection = getConnection();
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM Person";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("IDPerson"));
                person.setSurName(resultSet.getString("Surname"));
                person.setName(resultSet.getString("Name"));
                person.setCity(new City(resultSet.getString("City")));
                person.setEmail(resultSet.getString("Email"));
                people.add(person);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return people;
    }

    @Override
    public void insertPerson(Person person) {
        String sql = "INSERT INTO Person (IDPerson, Surname,Name, City, Email) VALUE(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getSurName());
            preparedStatement.setString(3, person.getName());
            preparedStatement.setString(4, person.getCity().getCityName());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void updatePerson(Person person) {
        String sql = "UPDATE Person SET Surname=?, Name=?, City=?,Email=? WHERE IDPerson=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, person.getSurName());
            statement.setString(2, person.getName());
            statement.setString(3, person.getCity().getCityName());
            statement.setString(4, person.getEmail());
            statement.setInt(5, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void deletePerson(Person person) {
        String sql = "DELETE FROM Person WHERE IDPerson=?";
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
