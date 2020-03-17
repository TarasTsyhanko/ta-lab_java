package com.epam.sql.banksystem.dao.databasedao;

import com.epam.sql.banksystem.config.mysql.MySQL;
import com.epam.sql.banksystem.dao.PersonDAO;
import com.epam.sql.banksystem.entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.sql.banksystem.config.CrudOperationConstants.*;

public class PersonDataBaseDAO implements PersonDAO<Person> {
    private static Logger log = LogManager.getLogger(PersonDataBaseDAO.class);

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_ALL_PERSONS)) {
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                personList.add(getPersonFromDB(rs));
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return personList;
    }

    @Override
    public Person getPersonByName(String firstName, String lastName) {
        Person person = new Person();
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(SELECT_PERSON_BY_FIRST_NAME)) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                person = getPersonFromDB(rs);
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
        return person;
    }

    @Override
    public void insertPerson(@NotNull Person person) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(INSERT_PERSON)) {
            ps.setInt(1, person.getId());
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getLastName());
            ps.setInt(4, person.getAge());
            ps.setString(5, person.getCountry());
            ps.setString(6, person.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void updatePerson(@NotNull Person person) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(UPDATE_PERSON)) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getAge());
            ps.setString(4, person.getCountry());
            ps.setString(5, person.getEmail());
            ps.setInt(6, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @Override
    public void deletePerson(@NotNull Person person) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement(DELETE_PERSON)) {
            ps.setInt(1, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        MySQL.closeConnection();
    }

    @NotNull
    private Person getPersonFromDB(@NotNull ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("IDPerson"));
        person.setFirstName(rs.getString("FirstName"));
        person.setLastName(rs.getString("LastName"));
        person.setAge(rs.getInt("Age"));
        person.setCountry(rs.getString("Country"));
        person.setEmail(rs.getString("Email"));
        return person;
    }

    public boolean isPersonExists(String firstName, String lastName) {
        String msg = "";
        try (CallableStatement ps = MySQL.getConnection().prepareCall("{call InsertPerson(?,?)}")) {
            ps.setString("FirstNamePersonIn", firstName);
            ps.setString("LastNameIn", lastName);
            try(ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                msg = rs.getString(1);
            }
            if(msg.equals("This Person already exists")){
                return true;
            }}
        } catch (SQLException e) {
            log.error("SQLException: " + e.getMessage() +"\n"+"SQLState: " + e.getSQLState());
        }
        return false;
    }
}
