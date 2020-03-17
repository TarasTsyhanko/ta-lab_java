package jdbc.dao;
import jdbc.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> getAllCities();
    void insertCity(City city);
    void deleteCity(City city);
}
