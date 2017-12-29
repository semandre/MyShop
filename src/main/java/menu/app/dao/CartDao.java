package menu.app.dao;

import menu.app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDao extends JpaRepository<Cart,Integer> {
    @Modifying
    @Query("update Cart c set c.quantity=:quantity where c.name=:name")
    void updateByName(@Param("name")String name,@Param("quantity")int quantity);

    @Query("from Cart c where c.sessionId=:sessionId")
    List<Cart> findAllBySessionId(@Param("sessionId") String sessionId);

}
