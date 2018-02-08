package menu.app.dao;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Integer> {
    Client findBySessionId(@Param("sessionId")String sessionId);

//    @Query(value = "SELECT * " +
//            "from Client c join  Orders o on c.order_id=o.id " +
//            "join  Cart ca on ca.order_id=o.id " +
//            "join  City ci on ci.id=c.city_id",nativeQuery = true)

//    @Query("from Client c join fetch c.order o join fetch o.cart ca join fetch c.city ci")
//    List<Client> findAllWithOrder();
    void deleteAllBySessionId(@Param("sessionId") String sessionId);
}
