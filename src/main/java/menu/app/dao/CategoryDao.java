package menu.app.dao;

import menu.app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    @Query("from Category c where c.name=:name")
    Category findByName(@Param("name") String name);
}
