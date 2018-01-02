package menu.app.service.impl;

import menu.app.dao.CartDao;
import menu.app.entity.Cart;
import menu.app.entity.Client;
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
    public void update(String sessionId,String name, int quantity) {
        cartDao.updateByName(sessionId,name,quantity);
    }

    @Override
    public void updateAll(Client client,String sessionId) {
        cartDao.updateAll(client,sessionId);
    }

    @Override
    public void updateSessionId( String sessionId,Client client ) {
        cartDao.updateSessionId(sessionId,client);
    }

    @Override
    public List<Cart> findAllBySessionId(String sessionId) {
        return cartDao.findAllBySessionId(sessionId);
    }


}
