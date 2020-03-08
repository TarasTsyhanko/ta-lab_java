package banksystem.jdbc;

import banksystem.jdbc.dao.CityDAO;
import banksystem.jdbc.entity.City;
import banksystem.jdbc.service.CityService;

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
