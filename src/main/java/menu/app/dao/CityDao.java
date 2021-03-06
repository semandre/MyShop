package menu.app.dao;

import menu.app.entity.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {

    @Query(" from City c where c.cityName=:cityName")
    City findByCityName(@Param("cityName") String cityName);

    @Query("from City c where c.cityName=:cName")
    List<City> fABCN(@Param("cName") String cityName);

    @Query("from City c")
    List<City> findAllBy(Pageable pageable);

}
