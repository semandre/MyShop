package menu.app.service;


import menu.app.entity.Client;
import menu.app.entity.Orders;

import java.util.List;

public interface OrdersService {

    void save(Orders orders);
    Orders findOne(String sessionId);
    List<Orders> findAll();
    void updateClient(String sessionId, Client client);
    void deleteAllBySessionId(String sessionId);
}
