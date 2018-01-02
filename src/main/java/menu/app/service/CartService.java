package menu.app.service;

import menu.app.entity.Cart;
import menu.app.entity.Client;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void save(Cart cart);
    void remove(int id);
    void update(String sessionId,String name,int quantity);
    void updateAll(Client client,String sessionId);
    void updateSessionId(String sessionId ,Client client);
    List<Cart> findAllBySessionId(String sessionId);
}
