package menu.app.dao;

import menu.app.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {

    @Query("from City c where c.cityName='тернопіль'")
    City findByCityName();

    @Query("from City c where c.cityName=:cityName")
    List<City> allCitiesWithName(@Param("cityName") String cityName);
    
}
