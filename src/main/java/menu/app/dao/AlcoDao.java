package menu.app.dao;

import menu.app.entity.Alcogol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlcoDao extends JpaRepository<Alcogol,Integer> {

    @Query("from Alcogol a where a.category=:category")
    public List<Alcogol> findAlcogolByCategory(@Param("category") String category);
}
