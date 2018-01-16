package menu.app.service.impl;


import menu.app.dao.OrdersDao;
import menu.app.entity.Client;
import menu.app.entity.Orders;
import menu.app.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    OrdersDao ordersDao;

    @Override
    public void save(Orders orders) {
        ordersDao.save(orders);
    }

    @Override
    public Orders findOne(String sessionId) {
        return ordersDao.findBySessionId(sessionId);
    }

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Override
    public void updateClient(String sessionId, Client client) {
        ordersDao.updateClient(sessionId,client);
    }
}
