package menu.app.dao;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import menu.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDao extends JpaRepository<Cart,Integer> {
    @Modifying
    @Query("update Cart c set c.quantity=:quantity,c.order=:orders where c.name=:name and c.sessionId=:sessionId")
    void updateByName(@Param("sessionId") String sessionId, @Param("name")String name,
                      @Param("quantity")int quantity, @Param("orders")Orders orders);

    @Modifying
    @Query("update Cart c set c.quantity=:quantity where c.name=:name and c.sessionId=:sessionId")
    void updateQuantityByName(@Param("sessionId") String sessionId, @Param("name")String name,
                      @Param("quantity")int quantity);


    @Query("from Cart c where c.sessionId=:sessionId")
    List<Cart> findAllBySessionId(@Param("sessionId") String sessionId);

    @Query("from Cart c join fetch c.order o join fetch o.client cl join fetch cl.city ci")
    List<Cart> findProductsWithOrder();

    void deleteAllBySessionId(@Param("sessionId") String sessionId);





}
