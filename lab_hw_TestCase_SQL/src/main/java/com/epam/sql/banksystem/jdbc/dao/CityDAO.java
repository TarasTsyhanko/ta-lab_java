package com.epam.sql.banksystem.jdbc.dao;
import com.epam.sql.banksystem.jdbc.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();
    void insertCity(City city);
    void deleteCity(City city);
}
