package menu.app.service;

import menu.app.entity.City;

import java.util.List;

public interface CityService {
    City findByCityName(String cityName);
    List<City> findAllByCityName(String cityName);
    List<City> findAll();
    List<City> findAllBy();
    void save(City city);

}
