package menu.app.service.impl;

import menu.app.dao.CartDao;
import menu.app.entity.Cart;
import menu.app.entity.Client;
import menu.app.entity.Orders;
import menu.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Override
    public List<Cart> findAll() {
       return cartDao.findAll();
    }

    @Override
    public void save(Cart cart) {
        cartDao.save(cart);
    }

    @Override
    public void remove(int id) {
        cartDao.delete(id);
    }

    @Override
    public void update(String sessionId, String name, int quantity, Orders orders) {
        cartDao.updateByName(sessionId,name,quantity,orders);
    }

    @Override
    public List<Cart> findAllBySessionId(String sessionId) {
        return cartDao.findAllBySessionId(sessionId);
    }

    @Override
    public List<Cart> findAllCartsWithOrder() {
        return cartDao.findProductsWithOrder();
    }

    @Override
    public void deleteAllBySessionId(String sessionId) {
        cartDao.deleteAllBySessionId(sessionId);
    }


}
