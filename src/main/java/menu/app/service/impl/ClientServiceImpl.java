package menu.app.service.impl;

import menu.app.dao.ClientDAO;
import menu.app.entity.Cart;
import menu.app.entity.Client;
import menu.app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDAO clientDAO;
    @Override
    public void save(Client client) {
        clientDAO.save(client);
    }

    @Override
    public List<Client> findAll() {
       return clientDAO.findAll();
    }


}
