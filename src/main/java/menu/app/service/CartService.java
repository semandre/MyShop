package menu.app.service;

import menu.app.entity.Cart;
import menu.app.entity.Client;
import menu.app.entity.Orders;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void save(Cart cart);
    void remove(int id);
    void update(String sessionId, String name, int quantity, Orders orders);
    List<Cart> findAllBySessionId(String sessionId);
    List<Cart> findAllCartsWithOrder();
}
