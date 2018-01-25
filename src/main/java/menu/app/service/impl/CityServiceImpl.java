package menu.app.service.impl;


import menu.app.dao.CityDao;
import menu.app.entity.City;
import menu.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public City findByCityName() {
        return cityDao.findByCityName();
    }

    @Override
    public List<City> findAllByCityName(String cityName) {
        return cityDao.fABCN(cityName);
    }

}
