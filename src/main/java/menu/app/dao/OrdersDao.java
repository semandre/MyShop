package menu.app.dao;


import menu.app.entity.Client;
import menu.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersDao extends JpaRepository<Orders,Integer>{

    @Query("from Orders o where o.sessionId=:sessionId")
    Orders findBySessionId(@Param("sessionId")String sessionId);
    @Query("update Orders o set client=:client where o.sessionId=:sessionId")
    @Modifying
    void updateClient(@Param("sessionId")String sessionId, @Param("client")Client client);

}
