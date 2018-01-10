package menu.app.dao;

import menu.app.entity.Alcogol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlcoDao extends JpaRepository<Alcogol,Integer> {

    @Query("from Alcogol a join fetch a.category c where c.id=:id")
    List<Alcogol> findAlcogolByCategory(@Param("id") int id);

    @Query("from Alcogol a join fetch a.category where a.id=:id")
    Alcogol findAllWithCategory(@Param("id") int id);
}
