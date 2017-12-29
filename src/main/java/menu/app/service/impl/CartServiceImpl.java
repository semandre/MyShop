package menu.app.service.impl;

import menu.app.dao.CartDao;
import menu.app.entity.Cart;
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
    public void update(String name, int quantity) {
        cartDao.updateByName(name,quantity);
    }

    @Override
    public List<Cart> findAllBySessionId(String sessionId) {
        return cartDao.findAllBySessionId(sessionId);
    }


}
