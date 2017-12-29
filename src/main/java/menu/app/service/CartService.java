package menu.app.service;

import menu.app.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void save(Cart cart);
    void remove(int id);
    void update(String name,int quantity);
    List<Cart> findAllBySessionId(String sessionId);
}
