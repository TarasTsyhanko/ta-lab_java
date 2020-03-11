package com.epam.sql.banksystem.jdbc.service;

import com.epam.sql.banksystem.jdbc.bo.Util;
import com.epam.sql.banksystem.jdbc.dao.CityDAO;
import com.epam.sql.banksystem.jdbc.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService extends Util implements CityDAO {
    private Connection connection;

    public CityService() {
        connection = getConnection();
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                City city = new City();
                city.setCityName(resultSet.getString("City"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return cities;
    }

    @Override
    public void insertCity(City city) {
        String sql = "INSERT INTO city (city) VALUE(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    @Override
    public void deleteCity(City city) {
        String sql = "DELETE FROM city WHERE city=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,city.getCityName());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
