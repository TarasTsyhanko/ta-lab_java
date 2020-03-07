package banksystem.dao.databasedao;

import banksystem.dao.PersonDAO;
import banksystem.entity.Person;
import banksystem.config.mysql.MySQLClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static banksystem.config.CrudOperationConstants.*;

public class PersonDataBaseDAO implements PersonDAO {
    private static Logger log = LogManager.getLogger(PersonDataBaseDAO.class);

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_ALL_PERSONS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personList.add(getPersonFromDB(resultSet));
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return personList;
    }

    @Override
    public Person getPersonByName(String firstName, String lastName) {
        Person person = new Person();
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(SELECT_PERSON_BY_FIRST_NAME)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                person = getPersonFromDB(resultSet);
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
        return person;
    }

    @Override
    public void insertPerson(@NotNull Person person) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(INSERT_PERSON)) {
            statement.setFloat(1, person.getId());
            statement.setString(2, person.getFirstName());
            statement.setString(3, person.getLastName());
            statement.setString(4, person.getNationality());
            statement.setString(5, person.getCountry());
            statement.setString(6, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void updatePerson(@NotNull Person person) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(UPDATE_PERSON)) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getNationality());
            statement.setString(4, person.getCountry());
            statement.setString(5, person.getEmail());
            statement.setFloat(6, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @Override
    public void deletePerson(@NotNull Person person) {
        try (PreparedStatement statement = MySQLClient.getConnection().prepareStatement(DELETE_PERSON)) {
            statement.setFloat(1, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
        }
        MySQLClient.closeConnection();
    }

    @NotNull
    private Person getPersonFromDB(@NotNull ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getFloat("IDPerson"));
        person.setFirstName(resultSet.getString("FirstName"));
        person.setLastName(resultSet.getString("LastName"));
        person.setNationality(resultSet.getString("Nationality"));
        person.setCountry(resultSet.getString("Country"));
        person.setEmail(resultSet.getString("Email"));
        return person;
    }

    public boolean isPersonExists(String firstName, String lastName) {
        String msg = "";
        try (CallableStatement statement = MySQLClient.getConnection().prepareCall("{call InsertPerson(?,?)}")) {
            statement.setString("FirstNamePersonIn", firstName);
            statement.setString("LastNameIn", lastName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                msg = rs.getString(1);
            }
            if(msg.equals("This Person already exists")){
                return true;
            }
        } catch (SQLException e) {
            log.error("SQLException: " + Arrays.toString(e.getStackTrace()) + "\n" + "SQLState: " + e.getSQLState());
            e.printStackTrace();
        }
        return false;
    }
}
