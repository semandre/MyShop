package menu.app.service.impl;


import menu.app.dao.CityDao;
import menu.app.entity.City;
import menu.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public City findByCityName(String cityName) {
        return cityDao.findByCityName(cityName);
    }

    @Override
    public List<City> findAllByCityName(String cityName) {
        return cityDao.fABCN(cityName);
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public List<City> findAllBy() {
       return cityDao.findAllBy(new PageRequest(0,100000));
    }

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

}
