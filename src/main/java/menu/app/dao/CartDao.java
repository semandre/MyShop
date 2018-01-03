package menu.app.dao;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDao extends JpaRepository<Cart,Integer> {
    @Modifying
    @Query("update Cart c set c.quantity=:quantity where c.name=:name and c.sessionId=:sessionId")
    void updateByName(@Param("sessionId") String sessionId,@Param("name")String name,@Param("quantity")int quantity);

    @Modifying
    @Query("update Cart c set c.client=:client where c.sessionId=:sessionId ")
    void updateAll(@Param("client")Client client,@Param("sessionId") String sessionId);

    @Modifying
    @Query("update Cart c  set c.sessionId=:sessionId where c.client=:client")
    void updateSessionId(@Param("sessionId") String sessionId,@Param("client")Client client);


    @Query("from Cart c where c.sessionId=:sessionId")
    List<Cart> findAllBySessionId(@Param("sessionId") String sessionId);

    @Query("from Cart as c  join fetch c.client as cl ")
    List<Cart> findByClient();



}
