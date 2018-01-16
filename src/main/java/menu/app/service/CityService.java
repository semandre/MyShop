package menu.app.service;

import menu.app.entity.City;

import java.util.List;

public interface CityService {
    City findByCityName();
    List<City> allCitiesWithName(String cityName);

}
