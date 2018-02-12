package menu.app.dao;

import menu.app.entity.Alcogol;
import menu.app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlcoDao extends JpaRepository<Alcogol,Integer> {

    @Query("from Alcogol a join fetch a.category c where c.id=:id")
    List<Alcogol> findAlcogolByCategory(@Param("id") int id);

    @Query("from Alcogol a join fetch a.category where a.id=:id")
    Alcogol findWithCategory(@Param("id") int id);

    @Query("from Alcogol a where a.name=:name")
    Alcogol findByName(@Param("name") String name);

    @Query("from Alcogol a join fetch a.category")
    List<Alcogol> findAllWithCathegories();

    @Modifying
    @Query("update Alcogol a set a.stock=:stock,a.status=:status,a.popularity=:popularity where a.name=:name")
    void updateStockAndStatusAndPopularity(@Param("stock") double stock,@Param("status") String status,@Param("popularity") double popularity,@Param("name") String name);

    @Modifying
    @Query("update Alcogol a set a.name=:name,a.status=:status,a.stock=:stock," +
            "a.description=:description,a.pic=:pic,a.price=:price,a.category=:category,a.packing=:packaging where a.id=:id")
    void updateItem(@Param("id") int id, @Param("name") String name, @Param("price") double price
            , @Param("stock") double stock, @Param("status") String status, @Param("description") String description,
                    @Param("category") Category category,@Param("packaging") double packaging);


}
