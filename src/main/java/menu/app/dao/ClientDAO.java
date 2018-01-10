package menu.app.dao;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Integer> {
    Client findBySessionId(@Param("sessionId")String sessionId);

}
