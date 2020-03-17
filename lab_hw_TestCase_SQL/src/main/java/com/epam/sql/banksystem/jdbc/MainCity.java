package com.epam.sql.banksystem.jdbc;

import com.epam.sql.banksystem.jdbc.dao.CityDAO;
import com.epam.sql.banksystem.jdbc.entity.City;
import com.epam.sql.banksystem.jdbc.service.CityService;

import java.util.List;

public class MainCity {
    public static void main(String[] args) {
        CityDAO cityDAO = new CityService();
        List<City> cityList = cityDAO.getAllCities();
        for (City city :cityList) {
            System.out.print(city.getCityName()+" ");
        }
        System.out.println();
        cityDAO.insertCity(new City("London"));
        System.out.println("------------------------------------------------------");
        cityList = cityDAO.getAllCities();
        for (City city :cityList) {
            System.out.print(city.getCityName()+" ");
        }
        System.out.println();
        cityDAO.deleteCity(new City("London"));
        System.out.println("------------------------------------------------------");
        cityList = cityDAO.getAllCities();
        for (City city :cityList) {
            System.out.print(city.getCityName()+" ");
        }
    }
}
